package masjidmuar.project.bms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import masjidmuar.project.bms.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
