package com.example.service;

import com.example.entities.MessageEntity;
import com.example.entities.MessageStatus;
import com.example.exception.MessageNotFoundException;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class MessageService {

    @Autowired
    private MessageRepository msRepository;

    public List<MessageEntity> findAll(){
        return msRepository.findAll();
    }

    public void saveMessage(MessageEntity message){
        msRepository.save(message);
    }

    public MessageEntity markAsSent(long id){
        Optional<MessageEntity> optMessage = msRepository.findById(id);

        if(optMessage.isEmpty()){
            throw new RuntimeException("Message not found with id=" + id);
        }

        MessageEntity message = optMessage.get();
        message.setStatus(MessageStatus.SENT);
        message.setSendAt(LocalDateTime.now());

        msRepository.save(message);
        return message;
    }

    public MessageEntity findById(long id){

        return msRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    public List<MessageEntity> findByStatus(MessageStatus status){
        return msRepository.findByStatus(status);
    }

    public List<MessageEntity> findByRecipient(String recipient){
        return msRepository.findByRecipient(recipient);
    }

    public List<MessageEntity> findByStatusAndRecipient(MessageStatus status, String recipient){
        return msRepository.findByStatusAndRecipient(status, recipient);
    }


}
