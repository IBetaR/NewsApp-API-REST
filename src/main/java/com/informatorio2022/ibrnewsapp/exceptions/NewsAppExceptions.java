package com.informatorio2022.ibrnewsapp.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NewsAppExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public NewsAppExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
