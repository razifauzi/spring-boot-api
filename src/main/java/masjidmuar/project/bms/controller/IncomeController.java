package masjidmuar.project.bms.controller;

import masjidmuar.project.bms.dto.IncomeDTO;
import masjidmuar.project.bms.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/income") 
@CrossOrigin(origins = {"http://localhost:3000", "https://cmssolution.com.my"})
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
    public IncomeDTO createIncome(@RequestBody IncomeDTO incomeDTO) {
        return incomeService.createIncome(incomeDTO);
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
