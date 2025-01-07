package masjidmuar.project.bms.model;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "VENDOR")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String name = "";

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT ''")
    private String description = "";

    @Column(nullable = false, updatable = false) 
    private LocalDateTime createdts;

    @Column(nullable = false)
    private LocalDateTime updatedts;

    @Column(nullable = false)
    private String fileName;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
