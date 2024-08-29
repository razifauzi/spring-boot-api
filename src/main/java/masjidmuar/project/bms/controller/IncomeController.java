package masjidmuar.project.bms.controller;

import masjidmuar.project.bms.model.Income;
import masjidmuar.project.bms.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:5173")
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
}
