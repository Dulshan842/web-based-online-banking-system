package com.banksystem.banksystem.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String acc;
    private BigDecimal amt;
    private LocalDate date;
    private String name;
    private String bank;
    private String reason;
    private String type;

    @Column(name = "CreatedAt", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    //  Add getters and setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // You can also generate all getters/setters:
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAcc() { return acc; }
    public void setAcc(String acc) { this.acc = acc; }

    public BigDecimal getAmt() { return amt; }
    public void setAmt(BigDecimal amt) { this.amt = amt; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}



