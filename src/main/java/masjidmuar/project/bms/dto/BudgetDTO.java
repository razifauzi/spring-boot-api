package masjidmuar.project.bms.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BudgetDTO {
    private UUID id;
    private int year = 1970;
    private String description = "";
    private BigDecimal amount1 = BigDecimal.ZERO; 
    private BigDecimal amount2 = BigDecimal.ZERO; 
    private BigDecimal amount3 = BigDecimal.ZERO; 
    private BigDecimal amount4 = BigDecimal.ZERO; 
    private BigDecimal amount5 = BigDecimal.ZERO; 
    private BigDecimal amount6 = BigDecimal.ZERO; 
    private BigDecimal amount7 = BigDecimal.ZERO; 
    private BigDecimal amount8 = BigDecimal.ZERO; 
    private BigDecimal amount9 = BigDecimal.ZERO; 
    private BigDecimal amount10 = BigDecimal.ZERO; 
    private BigDecimal amount11 = BigDecimal.ZERO; 
    private BigDecimal amount12 = BigDecimal.ZERO; 
    private LocalDateTime createdts;
    private LocalDateTime updatedts; 
    private String program = "";

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public BigDecimal getAmount3() {
        return amount3;
    }

    public void setAmount3(BigDecimal amount3) {
        this.amount3 = amount3;
    }

    public BigDecimal getAmount4() {
        return amount4;
    }

    public void setAmount4(BigDecimal amount4) {
        this.amount4 = amount4;
    }

    public BigDecimal getAmount5() {
        return amount5;
    }

    public void setAmount5(BigDecimal amount5) {
        this.amount5 = amount5;
    }

    public BigDecimal getAmount6() {
        return amount6;
    }

    public void setAmount6(BigDecimal amount6) {
        this.amount6 = amount6;
    }

    public BigDecimal getAmount7() {
        return amount7;
    }

    public void setAmount7(BigDecimal amount7) {
        this.amount7 = amount7;
    }

    public BigDecimal getAmount8() {
        return amount8;
    }

    public void setAmount8(BigDecimal amount8) {
        this.amount8 = amount8;
    }

    public BigDecimal getAmount9() {
        return amount9;
    }

    public void setAmount9(BigDecimal amount9) {
        this.amount9 = amount9;
    }

    public BigDecimal getAmount10() {
        return amount10;
    }

    public void setAmount10(BigDecimal amount10) {
        this.amount10 = amount10;
    }

    public BigDecimal getAmount11() {
        return amount11;
    }

    public void setAmount11(BigDecimal amount11) {
        this.amount11 = amount11;
    }

    public BigDecimal getAmount12() {
        return amount12;
    }

    public void setAmount12(BigDecimal amount12) {
        this.amount12 = amount12;
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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }



}
