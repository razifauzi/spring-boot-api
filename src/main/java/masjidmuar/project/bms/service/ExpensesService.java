package masjidmuar.project.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masjidmuar.project.bms.dto.ExpensesDTO;
import masjidmuar.project.bms.dto.RunningNumberDTO;
import masjidmuar.project.bms.model.Expenses;
import masjidmuar.project.bms.repository.ExpensesRepository;

@Service
public class ExpensesService {
     @Autowired
    private ExpensesRepository expensesRepository;

    @Autowired
    private RunningNumberService runningNumberService;

    public List<ExpensesDTO> getAllExpenses() {
        return expensesRepository.findAll()
                                .stream()
                                .map(this::mapToDTO)
                                .collect(Collectors.toList());
    }

    public ExpensesDTO getExpensesById(UUID id) {
        Expenses expenses = expensesRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Expenses not found"));
        return mapToDTO(expenses);
    }

    public ExpensesDTO createExpenses(ExpensesDTO expensesDTO) {
        Expenses expenses = mapToEntity(expensesDTO);
        String expensesPrefix = generateExpensesPrefix();
        expenses.setExpensesPrefix(expensesPrefix);
        expensesRepository.save(expenses);
        return mapToDTO(expenses);
    }

    public ExpensesDTO updateExpenses(UUID id, ExpensesDTO expensesDTO) {
        Expenses expenses = expensesRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Expenses not found"));
                                           expenses.setAmount(expensesDTO.getAmount());
                                           expenses.setName(expensesDTO.getName());
                                           expenses.setDescription(expensesDTO.getDescription());
                                           expenses.setFrequency(expensesDTO.getFrequency());
                                           expenses.setFileName(expensesDTO.getFileName());
                                           expenses.setProgram(expensesDTO.getProgram());
                                           expenses.setUpdatedts(LocalDateTime.now());
        expensesRepository.save(expenses);
        return mapToDTO(expenses);
    }

    public void deleteExpenses(UUID id) {
        expensesRepository.deleteById(id);
    }

    private ExpensesDTO mapToDTO(Expenses expenses) {
        ExpensesDTO dto = new ExpensesDTO();
        dto.setId(expenses.getId());
        dto.setAmount(expenses.getAmount());
        dto.setName(expenses.getName());
        dto.setDescription(expenses.getDescription());
        dto.setFrequency(expenses.getFrequency());
        dto.setFileName(expenses.getFileName());
        dto.setProgram(expenses.getProgram());
        dto.setCreatedts(expenses.getCreatedts());
        dto.setUpdatedts(expenses.getUpdatedts());
        dto.setExpensesPrefix(expenses.getExpensesPrefix());
        dto.setDate(expenses.getDate());
        return dto;
    }

    private Expenses mapToEntity(ExpensesDTO dto) {
        Expenses expenses = new Expenses();
        expenses.setAmount(dto.getAmount());
        expenses.setName(dto.getName());
        expenses.setDescription(dto.getDescription());
        expenses.setFrequency(dto.getFrequency());
        expenses.setFileName(dto.getFileName());
        expenses.setProgram(dto.getProgram());
        return expenses;
    }

         private String generateExpensesPrefix() {
        RunningNumberDTO runningNumberDTO = runningNumberService.incrementRunningNumber("EXP");
        return "EXP-" + String.format("%06d", runningNumberDTO.getCurrentNumber());
    }
}
