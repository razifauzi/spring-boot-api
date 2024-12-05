package masjidmuar.project.bms.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masjidmuar.project.bms.dto.PaymentDTO;
import masjidmuar.project.bms.model.Payment;
import masjidmuar.project.bms.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                                .stream()
                                .map(this::mapToDTO)
                                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(UUID id) {
        Payment payment = paymentRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Payment not found"));
        return mapToDTO(payment);
    }

    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = mapToEntity(paymentDTO);
        paymentRepository.save(payment);
        return mapToDTO(payment);
    }

    public PaymentDTO updatePayment(UUID id, PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setAmount(paymentDTO.getAmount());
        payment.setStatus(paymentDTO.getStatus());
        payment.setDamn(paymentDTO.getDamn());
        payment.setEmail(paymentDTO.getEmail());
        paymentRepository.save(payment);
        return mapToDTO(payment);
    }

    public void deletePayment(UUID id) {
        paymentRepository.deleteById(id);
    }

    private PaymentDTO mapToDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());
        dto.setDamn(payment.getDamn());
        dto.setEmail(payment.getEmail());
        return dto;
    }

    private Payment mapToEntity(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setStatus(dto.getStatus());
        payment.setDamn(dto.getDamn());
        payment.setEmail(dto.getEmail());
        return payment;
    }
}
