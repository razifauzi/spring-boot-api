package masjidmuar.project.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import masjidmuar.project.bms.model.RunningNumber;

@Repository
public interface RunningNumberRepository extends JpaRepository<RunningNumber, String> {
    RunningNumber findByPrefix(String prefix);
}