package com.web_bank.banking_system.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ScheduledTransactions")
public class ScheduledTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String acc;
    private BigDecimal amt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String name;
    private String bank;
    private String reason;
    private String type;

    @Column(name = "CreatedAt", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "IsConfirmed")
    private boolean isConfirmed;


    public void setId(int id) { this.id = id; }
    public void setAcc(String acc) { this.acc = acc; }
    public void setAmt(BigDecimal amt) { this.amt = amt; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setName(String name) { this.name = name; }
    public void setBank(String bank) { this.bank = bank; }
    public void setReason(String reason) { this.reason = reason; }
    public void setType(String type) { this.type = type; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setConfirmed(boolean confirmed) { this.isConfirmed = confirmed; }


    public int getId() { return id; }
    public String getAcc() { return acc; }
    public BigDecimal getAmt() { return amt; }
    public LocalDate getDate() { return date; }
    public String getName() { return name; }
    public String getBank() { return bank; }
    public String getReason() { return reason; }
    public String getType() { return type; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public boolean isConfirmed() { return isConfirmed; }
}

