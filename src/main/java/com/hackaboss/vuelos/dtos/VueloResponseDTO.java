package com.hackaboss.vuelos.dtos;

import lombok.Getter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
public class VueloResponseDTO {

    private int id;
    private String nombreVuelo;
    private String empresa;
    private String lugarSalida;
    private String lugarLlegada;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private long duracionDias;

    public VueloResponseDTO(int id, String nombreVuelo, String empresa,
                            String lugarSalida, String lugarLlegada,
                            LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.id = id;
        this.nombreVuelo = nombreVuelo;
        this.empresa = empresa;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.duracionDias = ChronoUnit.DAYS.between(fechaSalida, fechaLlegada);
    }
}