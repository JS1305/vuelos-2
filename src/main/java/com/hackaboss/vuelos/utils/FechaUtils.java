package com.hackaboss.vuelos.utils;

import java.time.LocalDate;

public class FechaUtils {

    public static boolean fechasValidas(LocalDate salida, LocalDate llegada) {
        return salida != null && llegada != null && !salida.isAfter(llegada);
    }
}