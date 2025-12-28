package com.hackaboss.vuelos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VueloNotFoundException.class)
    public ResponseEntity<String> handleNotFound(VueloNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(VueloBadRequestException.class)
    public ResponseEntity<String> handleBadRequest(VueloBadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}