package masjidmuar.project.bms.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import masjidmuar.project.bms.dto.ExpensesDTO;
import masjidmuar.project.bms.service.ExpensesService;

@RestController
@RequestMapping("/api/v1/expenses") 
@CrossOrigin("https://cmssolution.com.my")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @GetMapping
    public List<ExpensesDTO> getAllExpenses() {
        return expensesService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ExpensesDTO getExpensesById(@PathVariable UUID id) {
        return expensesService.getExpensesById(id);
    }

    @PostMapping
    public ExpensesDTO createExpenses(@RequestBody ExpensesDTO expensesDTO) {
        return expensesService.createExpenses(expensesDTO);
    }

    @PutMapping("/{id}")
    public ExpensesDTO updateExpenses(@PathVariable UUID id, @RequestBody ExpensesDTO expensesDTO) {
        return expensesService.updateExpenses(id, expensesDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenses(@PathVariable UUID id) {
        expensesService.deleteExpenses(id);
    }
}
