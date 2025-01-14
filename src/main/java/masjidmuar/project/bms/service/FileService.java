package masjidmuar.project.bms.service;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class FileService {

    private Integer MAX_ALLOWED_IMAGE_SIZE = 5 * 1024 * 1024; // 5MB
    private Integer MAX_ALLOWED_PDF_SIZE = 10 * 1024 * 1024; // 10MB

    private FileAwsS3Service awsS3Service;

    public FileService(FileAwsS3Service fileAwsS3Service) {
        this.awsS3Service = fileAwsS3Service;
    }

    public String uploadFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileType = StringUtils.getFilenameExtension(fileName);

        String[] allowedImageExtensions = {"jpeg", "jpg", "png", "gif"};
        String[] allowedPdfExtensions = {"pdf"};

        if (Arrays.stream(allowedImageExtensions).anyMatch(fileType::equalsIgnoreCase)) {
            handleImageUpload(file);
        } else if (Arrays.stream(allowedPdfExtensions).anyMatch(fileType::equalsIgnoreCase)) {
            handlePdfUpload(file);
        } else {
            throw new Exception("Invalid file type. Only images and PDFs are allowed.");
        }

        // Ensure the file is uploaded under the "images/" folder
        String s3ObjectKey = "images/" + generateUUID() + "." + fileType;
        return awsS3Service.getS3Url(s3ObjectKey);  // Return the S3 URL for the file
    }

    private void handleImageUpload(MultipartFile file) throws Exception {
        String fileType = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if (file.getSize() > MAX_ALLOWED_IMAGE_SIZE) {
            throw new Exception("Maximum image size is 5MB.");
        }

        String uploadImageName = "images/" + generateUUID() + "." + fileType;  // Ensure it goes under "images/" folder
        awsS3Service.uploadFileToS3(file, uploadImageName);
    }

    private void handlePdfUpload(MultipartFile file) throws Exception {
        String fileType = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if (file.getSize() > MAX_ALLOWED_PDF_SIZE) {
            throw new Exception("Maximum PDF size is 10MB.");
        }

        String uploadPdfName = "pdfs/" + generateUUID() + "." + fileType;  // Ensure it goes under "pdfs/" folder
        awsS3Service.uploadFileToS3(file, uploadPdfName);
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
