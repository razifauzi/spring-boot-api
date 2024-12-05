package masjidmuar.project.bms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import masjidmuar.project.bms.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, UUID>{
    
}
