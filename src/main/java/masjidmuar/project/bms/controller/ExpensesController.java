package masjidmuar.project.bms.controller;

import masjidmuar.project.bms.dto.ExpensesDTO;
import masjidmuar.project.bms.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expenses") 
@CrossOrigin(origins = {"http://localhost:3000", "https://cmssolution.com.my"})
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
