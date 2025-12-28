package com.hackaboss.vuelos.exceptions;

public class VueloNotFoundException extends RuntimeException {
    public VueloNotFoundException(int id) {
        super("Vuelo con id " + id + " no encontrado");
    }
}