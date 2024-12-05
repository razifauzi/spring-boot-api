package masjidmuar.project.bms.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double amount;
    private String status;
    private String damn;
    private String email;

         // Getter for id
         public UUID getId() {
            return id;
        }
    
        // Setter for id
        public void setId(UUID id) {
            this.id = id;
        }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDamn() {
        return damn;
    }

    public void setDamn(String damn) {
        this.damn = damn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
