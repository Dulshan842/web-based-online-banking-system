package com.banksystem.banksystem.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "LoginHistory")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "login_time", insertable = false, updatable = false)
    private Timestamp loginTime;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "note")
    private String note;  // NEW FIELD

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Timestamp getLoginTime() { return loginTime; }
    public void setLoginTime(Timestamp loginTime) { this.loginTime = loginTime; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getNote() { return note; }  // NEW GETTER
    public void setNote(String note) { this.note = note; }  // NEW SETTER
}