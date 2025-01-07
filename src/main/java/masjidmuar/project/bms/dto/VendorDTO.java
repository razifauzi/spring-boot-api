package masjidmuar.project.bms.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class VendorDTO {
    private UUID id;
    private String name = "";
    private String description = "";
    private LocalDateTime createdts;
    private LocalDateTime updatedts; 
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


}
