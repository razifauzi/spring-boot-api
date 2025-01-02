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

import masjidmuar.project.bms.dto.BudgetDTO;
import masjidmuar.project.bms.service.BudgetService;

@RestController
@RequestMapping("/api/v1/budget") 
@CrossOrigin("https://cmssolution.com.my")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public List<BudgetDTO> getAllBudgets() {
        return budgetService.getAllBudget();
    }

    @GetMapping("/{id}")
    public BudgetDTO getBudgetById(@PathVariable UUID id) {
        return budgetService.getBudgetById(id);
    }

    @PostMapping
    public BudgetDTO createBudget(@RequestBody BudgetDTO BudgetDTO) {
        return budgetService.createBudget(BudgetDTO);
    }

    @PutMapping("/{id}")
    public BudgetDTO updateBudget(@PathVariable UUID id, @RequestBody BudgetDTO BudgetDTO) {
        return budgetService.updateBudget(id, BudgetDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable UUID id) {
        budgetService.deleteBudget(id);
    }

}
