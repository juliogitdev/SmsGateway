package com.example.service;

import com.example.entities.MessageEntity;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


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
}
