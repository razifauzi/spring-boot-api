package masjidmuar.project.bms.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "MUAR_INCOME")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
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
    private LocalDate date;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdts;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String program = "";

    // Constructors
    public Income() {
        this.id = UUID.randomUUID(); // Generate UUID by default
    }

    public Income(String name, int frequency, String description, BigDecimal amount, LocalDate date,String program) {
        this.id = UUID.randomUUID(); // Generate UUID by default
        this.name = name;
        this.frequency = frequency;
        this.description = description;
        this.amount = amount; 
        this.date = date; 
        this.program = program;
    }

    @PrePersist
    protected void onCreate() {
        this.createdts = LocalDateTime.now(); // Automatically set created timestamp
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
    
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public LocalDateTime getCreatedts() {
        return createdts;
    }
}
