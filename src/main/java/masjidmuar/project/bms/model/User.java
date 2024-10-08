package masjidmuar.project.bms.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "MUAR_USER")
public class User {
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
    private int role = 0;

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT ''")
    private String description = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String email = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String username = "";

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdts;

    // Constructors
    public User() {
        this.id = UUID.randomUUID(); // Generate UUID by default
    }

    public User(String name, int role, String description,String email,String username) {
        this.id = UUID.randomUUID(); // Generate UUID by default
        this.name = name;
        this.role = role;
        this.description = description;
        this.email = email;
        this.username = username;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedts() {
        return createdts;
    }
}
