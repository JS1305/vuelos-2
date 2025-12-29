package com.hackaboss.vuelos.controllers;

import com.hackaboss.vuelos.dtos.VueloResponseDTO;
import com.hackaboss.vuelos.models.Vuelo;
import com.hackaboss.vuelos.services.VueloService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


 // Controlador REST encargado de exponer los endpoints relacionados con vuelos.
 // Permite realizar operaciones CRUD y consultas con filtros y ordenamiento.

@RestController
@RequestMapping("/vuelos")
@RequiredArgsConstructor
public class VueloController {

    // Servicio que contiene la lógica de negocio de los vuelos
    private final VueloService service;

    /**
     * Obtiene una lista de vuelos con filtros y ordenamiento opcionales.
     *
     * @param empresa        filtra por nombre de la aerolínea
     * @param lugarLlegada   filtra por destino
     * @param fechaSalida    filtra por fecha de salida
     * @param ordenarPor     campo por el cual ordenar los resultados
     * @param orden          tipo de orden (ASC o DESC)
     * @return lista de vuelos en formato DTO
     */
    @GetMapping
    public List<VueloResponseDTO> getVuelos(
            @RequestParam(required = false) String empresa,
            @RequestParam(required = false) String lugarLlegada,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaSalida,
            @RequestParam(required = false) String ordenarPor,
            @RequestParam(defaultValue = "ASC") String orden) {

        return service.obtenerVuelos(
                empresa, lugarLlegada, fechaSalida, ordenarPor, orden);
    }
    //Obtiene un vuelo por su identificador.
    @GetMapping("/{id}")
    public Vuelo getById(@PathVariable int id) {
        return service.obtenerPorId(id);
    }
    //Crea un nuevo vuelo. El ID se genera automáticamente si no se envía.
    @PostMapping
    public ResponseEntity<Vuelo> crear(@RequestBody Vuelo vuelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(vuelo));
    }
    //Actualiza un vuelo existente.
    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable int id, @RequestBody Vuelo vuelo) {
        return ResponseEntity.ok(service.actualizar(id, vuelo));
    }
    //Elimina un vuelo por su identificador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}