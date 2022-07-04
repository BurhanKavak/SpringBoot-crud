package com.burhan.app.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException (String message){
        super(message);
    }
}
