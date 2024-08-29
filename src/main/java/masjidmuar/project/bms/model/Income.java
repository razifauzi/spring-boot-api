package masjidmuar.project.bms.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "MUAR_INCOME")
public class Income {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String name = "";

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int frequency = 0;

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT ''")
    private String description = "";

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdts;

    // Constructors
    public Income() {
        this.id = UUID.randomUUID(); // Generate UUID by default
    }

    public Income(String name, int frequency, String description) {
        this.id = UUID.randomUUID(); // Generate UUID by default
        this.name = name;
        this.frequency = frequency;
        this.description = description;
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

    public LocalDateTime getCreatedts() {
        return createdts;
    }
}
