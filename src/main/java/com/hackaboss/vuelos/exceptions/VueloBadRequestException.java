package com.hackaboss.vuelos.exceptions;

public class VueloBadRequestException extends RuntimeException {
    public VueloBadRequestException(String message) {
        super(message);
    }
}