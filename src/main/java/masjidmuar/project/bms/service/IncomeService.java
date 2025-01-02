package masjidmuar.project.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public IncomeDTO createIncome(IncomeDTO IncomeDTO) {
        Income income = mapToEntity(IncomeDTO);
        String incomePrefix = generateIncomePrefix();
        income.setIncomePrefix(incomePrefix);
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
        income.setProgram(IncomeDTO.getProgram());
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
        dto.setProgram(income.getProgram());
        dto.setCreatedts(income.getCreatedts());
        dto.setUpdatedts(income.getUpdatedts());
        dto.setIncomePrefix(income.getIncomePrefix());
        dto.setDate(income.getDate());
        return dto;
    }

    private Income mapToEntity(IncomeDTO dto) {
        Income income = new Income();
        income.setAmount(dto.getAmount());
        income.setName(dto.getName());
        income.setDescription(dto.getDescription());
        income.setFrequency(dto.getFrequency());
        income.setFileName(dto.getFileName());
        income.setProgram(dto.getProgram());
        return income;
    }

     private String generateIncomePrefix() {
        RunningNumberDTO runningNumberDTO = runningNumberService.incrementRunningNumber("INC");
        return "INC-" + String.format("%06d", runningNumberDTO.getCurrentNumber());
    }
}
