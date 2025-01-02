package masjidmuar.project.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import masjidmuar.project.bms.dto.RunningNumberDTO;
import masjidmuar.project.bms.service.RunningNumberService;

@RestController
@RequestMapping("/api/v1/running-number")
public class RunningNumberController {

    @Autowired
    private RunningNumberService runningNumberService;

     // Endpoint to get the current running number by prefix
    @GetMapping("/{prefix}")
    public RunningNumberDTO getRunningNumber(@PathVariable String prefix) {
        return runningNumberService.getCurrentRunningNumber(prefix);
    }

    // Endpoint to increment the running number for a specific prefix
    @GetMapping("/{prefix}/increment")
    public RunningNumberDTO incrementRunningNumber(@PathVariable String prefix) {
        return runningNumberService.incrementRunningNumber(prefix);
    }
}