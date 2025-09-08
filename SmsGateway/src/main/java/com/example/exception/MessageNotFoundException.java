package com.example.exception;

import org.springframework.http.HttpStatus;

public class MessageNotFoundException extends RuntimeException{

    public MessageNotFoundException(long id){
        super("message not found with id = " + id);
    }

}
