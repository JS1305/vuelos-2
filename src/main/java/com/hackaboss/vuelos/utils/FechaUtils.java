package com.hackaboss.vuelos.utils;

import java.time.LocalDate;

//Clase utilitaria para validaciones relacionadas con fechas.
public class FechaUtils {

    //Verifica que las fechas no sean nulas y que la salida no sea posterior a la llegada.

    public static boolean fechasValidas(LocalDate salida, LocalDate llegada) {
        return salida != null && llegada != null && !salida.isAfter(llegada);
    }
}