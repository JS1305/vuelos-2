package com.hackaboss.vuelos.dtos;

import lombok.Getter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//DTO utilizado para devolver la información del vuelo al cliente. Incluye un campo calculado (duración del vuelo en días).

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

    //Constructor que calcula automáticamente la duración del vuelo.
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
        if (this.duracionDias < 0) {
            throw new IllegalArgumentException("La fecha de llegada no puede ser anterior a la fecha de salida");
        }
    }
}