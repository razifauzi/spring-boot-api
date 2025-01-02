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

import masjidmuar.project.bms.dto.VendorDTO;
import masjidmuar.project.bms.service.VendorService;

@RestController
@RequestMapping("/api/v1/vendor") 
@CrossOrigin("http://localhost:3000")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<VendorDTO> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public VendorDTO getIncomeById(@PathVariable UUID id) {
        return vendorService.getVendorById(id);
    }

    @PostMapping
    public VendorDTO createIncome(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createVendor(vendorDTO);
    }

    @PutMapping("/{id}")
    public VendorDTO updateIncome(@PathVariable UUID id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.updateVendor(id, vendorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable UUID id) {
        vendorService.deleteVendor(id);
    }

}
