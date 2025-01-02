package masjidmuar.project.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masjidmuar.project.bms.dto.RunningNumberDTO;
import masjidmuar.project.bms.model.RunningNumber;
import masjidmuar.project.bms.repository.RunningNumberRepository;

@Service
public class RunningNumberService {
    @Autowired
    private RunningNumberRepository runningNumberRepository;

    // Fetch the current running number for a given prefix
    public RunningNumberDTO getCurrentRunningNumber(String prefix) {
        RunningNumber runningNumber = runningNumberRepository.findByPrefix(prefix);
        if (runningNumber != null) {
            return new RunningNumberDTO(runningNumber.getCurrentNumber(),runningNumber.getPrefix());
        }
        return null; // Or handle the case when running number is not found
    }

    // Increment the running number for a given prefix
    public RunningNumberDTO incrementRunningNumber(String prefix) {
        RunningNumber runningNumber = runningNumberRepository.findByPrefix(prefix);
        if (runningNumber != null) {
            runningNumber.setCurrentNumber(runningNumber.getCurrentNumber() + 1);
            runningNumberRepository.save(runningNumber);
            return new RunningNumberDTO(runningNumber.getCurrentNumber(),runningNumber.getPrefix());
        }
        return null; // Handle appropriately if running number is not found
    }
}
