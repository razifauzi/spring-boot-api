package masjidmuar.project.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masjidmuar.project.bms.dto.VendorDTO;
import masjidmuar.project.bms.model.Vendor;
import masjidmuar.project.bms.repository.VendorRepository;

@Service
public class VendorService {
    
    @Autowired
    private VendorRepository vendorRepository;

    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                                .stream()
                                .map(this::mapToDTO)
                                .collect(Collectors.toList());
    }

    public VendorDTO getVendorById(UUID id) {
        Vendor vendor = vendorRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Vendor not found"));
        return mapToDTO(vendor);
    }

    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor vendor = mapToEntity(vendorDTO);
        vendorRepository.save(vendor);
        return mapToDTO(vendor);
    }

    public VendorDTO updateVendor(UUID id, VendorDTO VendorDTO) {
        Vendor vendor = vendorRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.setAmount(VendorDTO.getAmount());
        vendor.setName(VendorDTO.getName());
        vendor.setDescription(VendorDTO.getDescription());
        vendor.setFrequency(VendorDTO.getFrequency());
        vendor.setFileName(VendorDTO.getFileName());
        vendor.setProgram(VendorDTO.getProgram());
        vendor.setUpdatedts(LocalDateTime.now());
        vendorRepository.save(vendor);
        return mapToDTO(vendor);
    }

    public void deleteVendor(UUID id) {
        vendorRepository.deleteById(id);
    }

    private VendorDTO mapToDTO(Vendor vendor) {
        VendorDTO dto = new VendorDTO();
        dto.setId(vendor.getId());
        dto.setAmount(vendor.getAmount());
        dto.setName(vendor.getName());
        dto.setDescription(vendor.getDescription());
        dto.setFrequency(vendor.getFrequency());
        dto.setFileName(vendor.getFileName());
        dto.setProgram(vendor.getProgram());
        dto.setCreatedts(vendor.getCreatedts());
        dto.setUpdatedts(vendor.getUpdatedts());
        dto.setDate(vendor.getDate());
        return dto;
    }

    private Vendor mapToEntity(VendorDTO dto) {
        Vendor vendor = new Vendor();
        vendor.setAmount(dto.getAmount());
        vendor.setName(dto.getName());
        vendor.setDescription(dto.getDescription());
        vendor.setFrequency(dto.getFrequency());
        vendor.setFileName(dto.getFileName());
        vendor.setProgram(dto.getProgram());
        return vendor;
    }
}
