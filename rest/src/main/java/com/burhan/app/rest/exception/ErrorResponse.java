package com.burhan.app.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;

    public ErrorResponse (String message,List<String> details){
        this.message = message;
        this.details = details;
    }

}
