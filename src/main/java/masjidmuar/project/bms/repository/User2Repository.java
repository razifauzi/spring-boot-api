package masjidmuar.project.bms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import masjidmuar.project.bms.model.User2;

public interface User2Repository extends JpaRepository <User2, UUID> {
    
}
