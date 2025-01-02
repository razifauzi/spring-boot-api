package masjidmuar.project.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masjidmuar.project.bms.dto.BudgetDTO;
import masjidmuar.project.bms.model.Budget;
import masjidmuar.project.bms.repository.BudgetRepository;

@Service
public class BudgetService {
    
    @Autowired
    private BudgetRepository budgetRepository;

    public List<BudgetDTO> getAllBudget(){
        return budgetRepository.findAll()
                               .stream()
                               .map(this::mapToDTO)
                               .collect(Collectors.toList());
    }

    public BudgetDTO getBudgetById(UUID id) {
        Budget budget = budgetRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Budget not found"));
        return mapToDTO(budget);
    }

    public BudgetDTO createBudget(BudgetDTO BudgetDTO) {
        Budget budget = mapToEntity(BudgetDTO);
        budgetRepository.save(budget);
        return mapToDTO(budget);
    }

    public BudgetDTO updateBudget(UUID id, BudgetDTO BudgetDTO) {
        Budget budget = budgetRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Budget not found"));
        budget.setAmount1(BudgetDTO.getAmount1());
        budget.setAmount2(BudgetDTO.getAmount2());
        budget.setAmount3(BudgetDTO.getAmount3());
        budget.setAmount4(BudgetDTO.getAmount4());
        budget.setAmount5(BudgetDTO.getAmount5());
        budget.setAmount6(BudgetDTO.getAmount6());
        budget.setAmount7(BudgetDTO.getAmount7());
        budget.setAmount8(BudgetDTO.getAmount8());
        budget.setAmount9(BudgetDTO.getAmount9());
        budget.setAmount10(BudgetDTO.getAmount10());
        budget.setAmount11(BudgetDTO.getAmount11());
        budget.setAmount12(BudgetDTO.getAmount12());
        budget.setDescription(BudgetDTO.getDescription());
        budget.setYear(BudgetDTO.getYear());
        budget.setProgram(BudgetDTO.getProgram());
        budget.setUpdatedts(LocalDateTime.now());
        budgetRepository.save(budget);
        return mapToDTO(budget);
    }

    public void deleteBudget(UUID id) {
        budgetRepository.deleteById(id);
    }
    
    private BudgetDTO mapToDTO( Budget budget) {
        BudgetDTO dto = new BudgetDTO();
        dto.setId(budget.getId());
        dto.setYear(budget.getYear());
        dto.setAmount1(budget.getAmount1());
        dto.setAmount2(budget.getAmount2());
        dto.setAmount3(budget.getAmount3());
        dto.setAmount4(budget.getAmount4());
        dto.setAmount5(budget.getAmount5());
        dto.setAmount6(budget.getAmount6());
        dto.setAmount7(budget.getAmount7());
        dto.setAmount8(budget.getAmount8());
        dto.setAmount9(budget.getAmount9());
        dto.setAmount10(budget.getAmount10());
        dto.setAmount11(budget.getAmount11());
        dto.setAmount12(budget.getAmount12());
        dto.setDescription(budget.getDescription());
        dto.setProgram(budget.getProgram());
        dto.setCreatedts(budget.getCreatedts());
        dto.setUpdatedts(budget.getUpdatedts());
        return dto;
    }

    private Budget mapToEntity(BudgetDTO dto) {
        Budget budget = new Budget();
        budget.setYear(dto.getYear());
        budget.setAmount1(dto.getAmount1());
        budget.setAmount2(dto.getAmount2());
        budget.setAmount3(dto.getAmount3());
        budget.setAmount4(dto.getAmount4());
        budget.setAmount5(dto.getAmount5());
        budget.setAmount6(dto.getAmount6());
        budget.setAmount7(dto.getAmount7());
        budget.setAmount8(dto.getAmount8());
        budget.setAmount9(dto.getAmount9());
        budget.setAmount10(dto.getAmount10());
        budget.setAmount11(dto.getAmount11());
        budget.setAmount12(dto.getAmount12());
        budget.setDescription(dto.getDescription());
        budget.setProgram(dto.getProgram());
        return budget;
    }
}
