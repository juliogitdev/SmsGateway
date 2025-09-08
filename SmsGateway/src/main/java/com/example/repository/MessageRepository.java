package com.example.repository;

import com.example.entities.MessageEntity;
import com.example.entities.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository <MessageEntity, Long> {
    List<MessageEntity> findByStatus(MessageStatus status);
    List<MessageEntity> findByRecipient(String recipient);
    List<MessageEntity> findByStatusAndRecipient(MessageStatus status, String recipient);
}
