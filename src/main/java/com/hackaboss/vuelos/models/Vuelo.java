package com.hackaboss.vuelos.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Modelo que representa un vuelo dentro del sistema. No está vinculado a base de datos (persistencia en memoria).

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Vuelo {
    // Identificador del vuelo (se genera automáticamente)
    private Integer id;
    private String nombreVuelo;
    private String lugarSalida;
    private String empresa;
    private String lugarLlegada;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
}
