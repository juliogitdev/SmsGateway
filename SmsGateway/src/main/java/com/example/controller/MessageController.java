package com.example.controller;

import com.example.entities.MessageEntity;
import com.example.entities.MessageStatus;
import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping
    public MessageEntity saveMessage(@RequestBody MessageEntity ms){
        if(ms.getStatus() == null){
            ms.setStatus(MessageStatus.PENDING);
        }
        if(ms.getCreatedAt() == null){
            ms.setCreatedAt(LocalDateTime.now());
        }

        messageService.saveMessage(ms);
        return ms;
    }

    @GetMapping
    public List<MessageEntity> findAll(){
        return messageService.findAll();
    }

}
