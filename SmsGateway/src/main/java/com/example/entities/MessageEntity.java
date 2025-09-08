package com.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity()
@Table(name = "message")
public class MessageEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private String recipient;

    @Enumerated(EnumType.STRING)
    @Column
    private MessageStatus status;

    @Column
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime sendAt;

    public MessageEntity() {

    }

    public MessageEntity (String body, String recipient) {
        this.body = body;
        this.recipient = recipient;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getSendAt() {
        return sendAt;
    }

    public void setSendAt(LocalDateTime sendAt) {
        this.sendAt = sendAt;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", recipient='" + recipient + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", sendAt=" + sendAt +
                '}';
    }
}
