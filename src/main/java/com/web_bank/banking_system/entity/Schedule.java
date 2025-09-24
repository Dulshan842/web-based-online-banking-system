package com.web_bank.banking_system.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Schedule {

    private int id;
    private String acc;
    private BigDecimal amt;
    private LocalDate date;
    private String name;
    private String bank;
    private String reason;
    private String type;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAcc() { return acc; }
    public void setAcc(String acc) { this.acc = acc; }

    public BigDecimal getAmt() { return amt; }
    public void setAmt(BigDecimal amt) { this.amt = amt; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}

