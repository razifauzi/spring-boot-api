package masjidmuar.project.bms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import masjidmuar.project.bms.model.Vendor;



@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {
}
