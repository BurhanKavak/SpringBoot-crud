package com.burhan.app.rest.exception;

public class UserNotNullException extends RuntimeException{

    public UserNotNullException (String message){
        super(message);
    }
}
