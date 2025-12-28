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

@RestController
@RequestMapping("/vuelos")
@RequiredArgsConstructor
public class VueloController {

    private final VueloService service;

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

    @GetMapping("/{id}")
    public Vuelo getById(@PathVariable int id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear(@RequestBody Vuelo vuelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(vuelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable int id, @RequestBody Vuelo vuelo) {
        return ResponseEntity.ok(service.actualizar(id, vuelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}