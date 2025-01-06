package masjidmuar.project.bms.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import masjidmuar.project.bms.dto.IncomeDTO;
import masjidmuar.project.bms.service.IncomeService;

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
