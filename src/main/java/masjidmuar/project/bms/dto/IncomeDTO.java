package masjidmuar.project.bms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class IncomeDTO {
    private UUID id;
    private String name = "";
    private int frequency = 0;
    private String description = "";
    private BigDecimal amount = BigDecimal.ZERO; 
    private LocalDate date;
    private LocalDateTime createdts;
    private String program = "";
    private String fileName;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount; // Getter for amount
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount; // Setter for amount
    }

    public LocalDate getDate() {
        return date; // Getter for date
    }

    public void setDate(LocalDate date) {
        this.date = date; // Setter for date
    }
    
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public LocalDateTime getCreatedts() {
        return createdts;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
