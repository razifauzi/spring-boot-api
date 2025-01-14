package masjidmuar.project.bms.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import masjidmuar.project.bms.dto.IncomeDTO;
import masjidmuar.project.bms.service.IncomeService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/income") 
public class IncomeController {

    @Autowired
    private IncomeService incomeService;


    @GetMapping
    public List<IncomeDTO> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @GetMapping("/{id}")
    public IncomeDTO getIncomeById(@PathVariable UUID id) {
        return incomeService.getIncomeById(id);
    }

    @PostMapping
    public IncomeDTO createIncome(@RequestParam("name") String name,
                                  @RequestParam("amount") BigDecimal amount,
                                  @RequestParam("description") String description,
                                  @RequestParam("frequency") int frequency,
                                  @RequestParam("category") String category,
                                  @RequestParam("paymentMethod") String paymentMethod,
                                  @RequestParam("receivedts") LocalDateTime receivedts,
                                  @RequestParam(required = false) MultipartFile file) throws Exception {
        // Create IncomeDTO from the form data
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setName(name);
        incomeDTO.setAmount(amount);
        incomeDTO.setDescription(description);
        incomeDTO.setFrequency(frequency);
        incomeDTO.setCategory(category);
        incomeDTO.setPaymentMethod(paymentMethod);
        incomeDTO.setReceivedts(receivedts);

        // Call the service to create Income with the file
        return incomeService.createIncome(incomeDTO, file);
    }

    @PutMapping("/{id}")
    public IncomeDTO updateIncome(@PathVariable UUID id, @RequestBody IncomeDTO incomeDTO) {
        return incomeService.updateIncome(id, incomeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable UUID id) {
        incomeService.deleteIncome(id);
    }

}
