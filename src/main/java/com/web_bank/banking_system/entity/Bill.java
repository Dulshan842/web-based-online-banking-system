package com.web_bank.banking_system.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Bills")
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private BigDecimal amt;
    @Column(name = "CreatedAt", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}


