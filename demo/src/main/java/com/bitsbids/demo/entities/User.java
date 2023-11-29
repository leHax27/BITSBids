package com.bitsbids.demo.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

public class User {





    @Id
    @Column(columnDefinition = "CHAR(15)")
    private String id;
    @Column(columnDefinition = "VARCHAR(255)")
    private String username;
    @Column(columnDefinition = "VARCHAR(255)")
    private String email;
    @Column(columnDefinition = "VARCHAR(255)")
    private String phone;
    @Column(columnDefinition = "VARCHAR(255)")
    private String password;
    @Column(columnDefinition = "BIGINT")
    private long wallet_amt;
    @Column(columnDefinition = "INT")
    private int money;

    public User() {
        // default constructor
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getWallet_amt() {
        return wallet_amt;
    }

    public void setWallet_amt(long wallet_amt) {
        this.wallet_amt = wallet_amt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public User(String id, String username, String email, String phone, String password, long wallet_amt, int money) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.wallet_amt = wallet_amt;
        this.money = money;
    }
    // Constructors, getters, and setters as needed

    // Remember to generate appropriate constructors, getters, and setters for the new fields.
    // Also, ensure you have the necessary imports for annotations.
}
