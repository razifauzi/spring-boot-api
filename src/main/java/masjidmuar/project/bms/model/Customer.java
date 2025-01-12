package masjidmuar.project.bms.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String name = "";

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int frequency = 0;

    @Column(nullable = false, precision = 19, scale = 2) 
    private BigDecimal amount = BigDecimal.ZERO; 

    @Column(nullable = false)
    private LocalDate date = LocalDate.of(1970, 1, 1); 

    @Column(nullable = false, updatable = false) 
    private LocalDateTime createdts;

    @Column(nullable = false)
    private LocalDateTime updatedts;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
    private String customerType = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
    private String salutation = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String firstName = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String lastName = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String companyName = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String displayName = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String email = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
    private String mobileNo = "";

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String website = "";

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT ''")
    private String remarks = "";

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT ''")
    private String billingAddress = "";

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT ''")
    private String shippingAddress = "";

    @OneToMany(mappedBy = "customer")
    private List<Income> incomes;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
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
    
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public void setCreatedts(LocalDateTime createdts) {
        this.createdts = createdts;
    }
}
