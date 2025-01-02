package masjidmuar.project.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masjidmuar.project.bms.dto.CustomerDTO;
import masjidmuar.project.bms.model.Customer;
import masjidmuar.project.bms.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                                .stream()
                                .map(this::mapToDTO)
                                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToDTO(customer);
    }

    public CustomerDTO createCustomer(CustomerDTO CustomerDTO) {
        Customer customer = mapToEntity(CustomerDTO);
        customerRepository.save(customer);
        return mapToDTO(customer);
    }

    public CustomerDTO updateCustomer(UUID id, CustomerDTO CustomerDTO) {
        Customer customer = customerRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setAmount(CustomerDTO.getAmount());
        customer.setName(CustomerDTO.getName());
        customer.setRemarks(CustomerDTO.getRemarks());
        customer.setFrequency(CustomerDTO.getFrequency());
        customer.setFileName(CustomerDTO.getFileName());
        customer.setSalutation(CustomerDTO.getSalutation());
        customer.setCompanyName(CustomerDTO.getCompanyName());
        customer.setDisplayName(CustomerDTO.getDisplayName());
        customer.setFirstName(CustomerDTO.getFirstName());
        customer.setLastName(CustomerDTO.getLastName());
        customer.setEmail(CustomerDTO.getEmail());
        customer.setMobileNo(CustomerDTO.getMobileNo());
        customer.setWebsite(CustomerDTO.getWebsite());
        customer.setBillingAddress(CustomerDTO.getBillingAddress());
        customer.setShippingAddress(CustomerDTO.getShippingAddress());
        customer.setCustomerType(CustomerDTO.getCustomerType());
        customer.setUpdatedts(LocalDateTime.now());
        customerRepository.save(customer);
        return mapToDTO(customer);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setAmount(customer.getAmount());
        dto.setName(customer.getName());
        dto.setRemarks(customer.getRemarks());
        dto.setFrequency(customer.getFrequency());
        dto.setFileName(customer.getFileName());
        dto.setSalutation(customer.getSalutation());
        dto.setCreatedts(customer.getCreatedts());
        dto.setCompanyName(customer.getCompanyName());
        dto.setDisplayName(customer.getDisplayName());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setMobileNo(customer.getMobileNo());
        dto.setWebsite(customer.getWebsite());
        dto.setBillingAddress(customer.getBillingAddress());
        dto.setShippingAddress(customer.getShippingAddress());
        dto.setCustomerType(customer.getCustomerType());
        dto.setUpdatedts(customer.getUpdatedts());
        dto.setDate(customer.getDate());
        return dto;
    }

    private Customer mapToEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setAmount(dto.getAmount());
        customer.setName(dto.getName());
        customer.setRemarks(dto.getRemarks());
        customer.setFrequency(dto.getFrequency());
        customer.setFileName(dto.getFileName());
        customer.setSalutation(dto.getSalutation());
        customer.setCompanyName(dto.getCompanyName());
        customer.setDisplayName(dto.getDisplayName());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNo(dto.getMobileNo());
        customer.setWebsite(dto.getWebsite());
        customer.setBillingAddress(dto.getBillingAddress());
        customer.setShippingAddress(dto.getShippingAddress());
        customer.setCustomerType(dto.getCustomerType());
        return customer;
    }
}
