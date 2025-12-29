package com.hackaboss.vuelos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Manejador global de excepciones para la aplicación. Centraliza el control de errores y evita respuestas genéricas.

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Maneja los errores cuando un vuelo no es encontrado.
    @ExceptionHandler(VueloNotFoundException.class)
    public ResponseEntity<String> handleNotFound(VueloNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    //Maneja errores de validación o solicitudes incorrectas.
    @ExceptionHandler(VueloBadRequestException.class)
    public ResponseEntity<String> handleBadRequest(VueloBadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}