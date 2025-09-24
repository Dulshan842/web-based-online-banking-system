package com.web_bank.banking_system.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

