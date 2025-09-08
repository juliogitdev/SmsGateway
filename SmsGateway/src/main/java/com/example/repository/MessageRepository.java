package com.example.repository;

import com.example.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository <MessageEntity, Long> {

}
