package com.burhan.app.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class UserExceptionHandler {
    ErrorResponse errorResponse;

    @ExceptionHandler(UserNotNullException.class)
    public ResponseEntity<?> userNotNull (UserNotNullException userNotNullException){
        List<String> detail = new ArrayList<>();
        detail.add(userNotNullException.getMessage());
        errorResponse = new ErrorResponse("Kullanıcı null olamaz",detail);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
     }

     @ExceptionHandler(UserNotFoundException.class)
     public ResponseEntity<?> userNotFound (UserNotFoundException userNotFoundException){
        List<String> detail = new ArrayList<>();
        detail.add(userNotFoundException.getMessage());
        errorResponse = new ErrorResponse("Kullanıcı Bulunamadı",detail);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
     }
}
