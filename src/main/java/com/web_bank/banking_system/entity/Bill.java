package com.web_bank.banking_system.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private BigDecimal amt;

    @Column(name = "CreatedAt", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    // Setters
    public void setId(int id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setAmt(BigDecimal amt) { this.amt = amt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // Getters
    public int getId() { return id; }
    public String getType() { return type; }
    public BigDecimal getAmt() { return amt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

