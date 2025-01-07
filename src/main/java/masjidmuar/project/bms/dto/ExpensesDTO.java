package masjidmuar.project.bms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExpensesDTO {
    private UUID id;
    private String name = "";
    private int frequency = 0;
    private String description = "";
    private BigDecimal amount = BigDecimal.ZERO; 
    private LocalDate date;
    private LocalDateTime createdts;
    private LocalDateTime updatedts; 
    private String category = "";
    private String paymentMethod = "";
    private LocalDateTime issuedts;
    private String fileName;
    private String expensesPrefix;

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
    
    
    public LocalDateTime getCreatedts() {
        return createdts;
    }

    public void setCreatedts(LocalDateTime createdts) {
        this.createdts = createdts;
    }

    public LocalDateTime getUpdatedts() {
        return updatedts;
    }

    public void setUpdatedts(LocalDateTime updatedts) {
        this.updatedts = updatedts;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExpensesPrefix() {
        return expensesPrefix;
    }

    public void setExpensesPrefix(String expensesPrefix) {
        this.expensesPrefix = expensesPrefix;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getIssuedts() {
        return issuedts;
    }

    public void setIssuedts(LocalDateTime issuedts) {
        this.issuedts = issuedts;
    }

    
}
