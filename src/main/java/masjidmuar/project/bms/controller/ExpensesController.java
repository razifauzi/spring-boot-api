package masjidmuar.project.bms.controller;

import masjidmuar.project.bms.model.Expenses;
import masjidmuar.project.bms.repository.ExpensesRepository;
import masjidmuar.project.bms.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/expenses") // Add a base URL for consistency
public class ExpensesController {

    @Autowired
    private ExpensesRepository expensesRepository;

    // Get all Expenses
    @GetMapping
    public List<Expenses> getAllIExpenses() {
        return expensesRepository.findAll();
    }

    // Get Expenses by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expenses> getExpensesById(@PathVariable UUID id) {
        Optional<Expenses> expenses = expensesRepository.findById(id);
        return expenses.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new Expenses
    @PostMapping
    public Expenses createExpenses(@RequestBody Expenses income) {
        return expensesRepository.save(income);
    }

    // Update an existing Expenses
    @PutMapping("/{id}")
    public ResponseEntity<Expenses> updateExpenses(@PathVariable UUID id, @RequestBody Expenses updatedExpenses) {
        return expensesRepository.findById(id).map(expenses -> {
            expenses.setName(updatedExpenses.getName());
            expenses.setFrequency(updatedExpenses.getFrequency());
            expenses.setDescription(updatedExpenses.getDescription());
            Expenses savedExpenses = expensesRepository.save(expenses);
            return ResponseEntity.ok(savedExpenses);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Expenses
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenses(@PathVariable UUID id) {
        try {
            expensesRepository.deleteById(id);
            return ResponseEntity.ok("Data deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
