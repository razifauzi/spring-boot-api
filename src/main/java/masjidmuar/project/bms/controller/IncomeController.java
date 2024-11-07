package masjidmuar.project.bms.controller;

import masjidmuar.project.bms.model.Income;
import masjidmuar.project.bms.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.MediaType;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/income") // Add a base URL for consistency
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    // Get all income
    @GetMapping
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    // Get income by ID
    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable UUID id) {
        Optional<Income> income = incomeRepository.findById(id);
        return income.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new income
    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    // Update an existing income
    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable UUID id, @RequestBody Income updatedIncome) {
        return incomeRepository.findById(id).map(income -> {
            income.setName(updatedIncome.getName());
            income.setFrequency(updatedIncome.getFrequency());
            income.setDescription(updatedIncome.getDescription());
            Income savedIncome = incomeRepository.save(income);
            return ResponseEntity.ok(savedIncome);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete income
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIncome(@PathVariable UUID id) {
        try {
            incomeRepository.deleteById(id);
            return ResponseEntity.ok("Data deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

   @GetMapping("/export/pdf")
    public ResponseEntity<byte[]> exportIncomeToPDF() {
        try {
            // Create ByteArrayOutputStream to write the PDF content
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            // Create a document and set page size
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, out);

            // Open the document to add content
            document.open();

            // Add title to the document
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph title = new Paragraph("Income Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add a blank line after the title
            document.add(new Paragraph(" "));

            // Create a table with 5 columns
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);

            // Define header cells with a background color
            String[] headers = {"Name", "Frequency", "Description", "Amount", "Date"};
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            for (String headerTitle : headers) {
                PdfPCell header = new PdfPCell(new Phrase(headerTitle, headerFont));
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(header);
            }

            // Fetch income data and add rows to the table
            List<Income> incomes = incomeRepository.findAll();
            for (Income income : incomes) {
                table.addCell(new PdfPCell(new Phrase(income.getName())));
                table.addCell(new PdfPCell(new Phrase(income.getFrequency())));
                table.addCell(new PdfPCell(new Phrase(income.getDescription())));
                table.addCell(new PdfPCell(new Phrase(income.getAmount().toString())));
                table.addCell(new PdfPCell(new Phrase(income.getDate().toString())));
            }

            // Add the table to the document
            document.add(table);

            // Close the document to finalize the PDF
            document.close();

            // Set HTTP headers for file download
            HttpHeaders headersResponse = new HttpHeaders();
            headersResponse.add("Content-Disposition", "attachment; filename=income_report.pdf");

            // Return the PDF as a byte array in the response
            return ResponseEntity.ok()
                    .headers(headersResponse)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(out.toByteArray());

        } catch (Exception ex) {
            // Handle any exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
