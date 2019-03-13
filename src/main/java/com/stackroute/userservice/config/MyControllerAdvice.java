package com.stackroute.userservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptiionHandler(Exception e){
        return new ResponseEntity<>("Error thrown globally : "+e.getMessage(), HttpStatus.CONFLICT);
    }
}
