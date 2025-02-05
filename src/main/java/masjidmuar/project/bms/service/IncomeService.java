package masjidmuar.project.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import masjidmuar.project.bms.dto.IncomeDTO;
import masjidmuar.project.bms.dto.RunningNumberDTO;
import masjidmuar.project.bms.model.Income;
import masjidmuar.project.bms.repository.IncomeRepository;

@Service
public class IncomeService {
    
    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private RunningNumberService runningNumberService;

    @Autowired
    private FileService fileService;


    public List<IncomeDTO> getAllIncomes() {
        return incomeRepository.findAll()
                                .stream()
                                .map(this::mapToDTO)
                                .collect(Collectors.toList());
    }

    public IncomeDTO getIncomeById(UUID id) {
        Income income = incomeRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Income not found"));
        return mapToDTO(income);
    }

    public IncomeDTO createIncome(IncomeDTO incomeDTO, MultipartFile file) throws Exception {
        Income income = mapToEntity(incomeDTO);
        String incomePrefix = generateIncomePrefix();
        income.setIncomePrefix(incomePrefix);

        // Handle file upload if a file is provided
        if (file != null && !file.isEmpty()) {
            String fileUrl = fileService.uploadFile(file);  // Save the file and get the URL
            income.setFileName(fileUrl);  // Set the file URL in the income object
        }

        incomeRepository.save(income);
        return mapToDTO(income);

    }

    public IncomeDTO updateIncome(UUID id, IncomeDTO IncomeDTO) {
        Income income = incomeRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Income not found"));
        income.setAmount(IncomeDTO.getAmount());
        income.setName(IncomeDTO.getName());
        income.setDescription(IncomeDTO.getDescription());
        income.setFrequency(IncomeDTO.getFrequency());
        income.setFileName(IncomeDTO.getFileName());
        income.setCategory(IncomeDTO.getCategory());
        income.setUpdatedts(LocalDateTime.now());
        incomeRepository.save(income);
        return mapToDTO(income);
    }

    public void deleteIncome(UUID id) {
        incomeRepository.deleteById(id);
    }

    private IncomeDTO mapToDTO(Income income) {
        IncomeDTO dto = new IncomeDTO();
        dto.setId(income.getId());
        dto.setAmount(income.getAmount());
        dto.setName(income.getName());
        dto.setDescription(income.getDescription());
        dto.setFrequency(income.getFrequency());
        dto.setFileName(income.getFileName());
        dto.setCategory(income.getCategory());
        dto.setCreatedts(income.getCreatedts());
        dto.setUpdatedts(income.getUpdatedts());
        dto.setIncomePrefix(income.getIncomePrefix());
        dto.setPaymentMethod(income.getPaymentMethod());
        dto.setReceivedts(income.getReceivedts());
        return dto;
    }

    private Income mapToEntity(IncomeDTO dto) {
        Income income = new Income();
        income.setAmount(dto.getAmount());
        income.setName(dto.getName());
        income.setDescription(dto.getDescription());
        income.setFrequency(dto.getFrequency());
        income.setFileName(dto.getFileName());
        income.setCategory(dto.getCategory());
        income.setPaymentMethod(dto.getPaymentMethod());
        income.setReceivedts(dto.getReceivedts());
        return income;
    }

     private String generateIncomePrefix() {
        RunningNumberDTO runningNumberDTO = runningNumberService.incrementRunningNumber("INC");
        return "INC-" + String.format("%06d", runningNumberDTO.getCurrentNumber());
    }
}
