package masjidmuar.project.bms.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "INCOME")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String name = "";

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int frequency = 0;

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT ''")
    private String description = "";

    @Column(nullable = false, precision = 19, scale = 2) 
    private BigDecimal amount = BigDecimal.ZERO; 

    @Column(nullable = false)
    private LocalDate date = LocalDate.of(1970, 1, 1); 

    @Column(nullable = false, updatable = false) 
    private LocalDateTime createdts;

    @Column(nullable = false)
    private LocalDateTime updatedts;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String category = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String paymentMethod = "";

    @Column(nullable = false)
    private LocalDateTime receivedts;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String incomePrefix;

    @ManyToOne
    private Customer customer;

    @PrePersist
    protected void onCreate() {
        this.createdts = LocalDateTime.now(); 
        this.updatedts = LocalDateTime.now(); 
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedts = LocalDateTime.now(); // Automatically set updated timestamp
    }

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
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedts() {
        return createdts;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIncomePrefix() {
        return incomePrefix;
    }

    public void setIncomePrefix(String incomePrefix) {
        this.incomePrefix = incomePrefix;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getReceivedts() {
        return receivedts;
    }

    public void setReceivedts(LocalDateTime receivedts) {
        this.receivedts = receivedts;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
