package masjidmuar.project.bms.controller;

import masjidmuar.project.bms.model.Expenses;
import masjidmuar.project.bms.model.Income;
import masjidmuar.project.bms.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;

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

// @PostMapping(consumes = {"multipart/form-data"})
//     public ResponseEntity<Income> createIncome(
//             @RequestParam("name") String name,
//             @RequestParam("frequency") int frequency,
//             @RequestParam("description") String description,
//             @RequestParam("amount") BigDecimal amount,
//             @RequestParam("date") LocalDate date,
//             @RequestParam("program") String program,
//             @RequestParam("file") MultipartFile file) {

//         Income income = new Income(name, frequency, description, amount, date, program, file.getOriginalFilename());

//         try {
//             // Handle file upload, if needed, e.g., save to the filesystem or cloud storage
//             // Code for saving file goes here (optional)

//             incomeRepository.save(income);
//             return ResponseEntity.ok(income);

//         } catch (Exception e) {
//             return ResponseEntity.status(500).body(null);
//         }
//     }

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
