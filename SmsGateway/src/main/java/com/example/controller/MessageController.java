package com.example.controller;

import com.example.entities.MessageEntity;
import com.example.entities.MessageStatus;
import com.example.service.MessageService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/messages")
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

    @GetMapping("/{id}")
    public MessageEntity findById(@PathVariable long id){
        return messageService.findById(id);
    }

    @PutMapping("/{id}/send")
    public void markAsSend(@PathVariable long id){
        messageService.markAsSent(id);
    }

    @GetMapping("/filter")
    public List<MessageEntity> filterMessage(
            @RequestParam(required = false) MessageStatus status,
            @RequestParam(required = false) String recipient
    ){
        if(status == null & recipient == null){
            throw new RuntimeException("filter not found");
        }

        if(status != null & recipient != null){
            return messageService.findByStatusAndRecipient(status, recipient);
        } else if (status != null) {
            return messageService.findByStatus(status);
        } else{
            return messageService.findByRecipient(recipient);
        }


    }




}
