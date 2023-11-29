package com.bitsbids.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;

        @Column(name = "sender_id", nullable = false)
        private String sender;

        @Column(name = "recipient_id", nullable = false)
        private String recipient;

        @Column(columnDefinition = "TEXT")
        private String content;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;


    // Constructors, getters, and setters

    public Message() {
        // Default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Message(String sender, String recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public Message(String id, String sender, String recipient, String content, LocalDateTime createdAt) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Other constructors, getters, and setters as needed
}
