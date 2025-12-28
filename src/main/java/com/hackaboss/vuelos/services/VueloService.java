package com.hackaboss.vuelos.services;


import com.hackaboss.vuelos.dtos.VueloResponseDTO;
import com.hackaboss.vuelos.exceptions.VueloBadRequestException;
import com.hackaboss.vuelos.exceptions.VueloNotFoundException;
import com.hackaboss.vuelos.models.Vuelo;
import com.hackaboss.vuelos.repositories.VueloRepository;
import com.hackaboss.vuelos.utils.FechaUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VueloService {

    private final VueloRepository repository;

    public List<VueloResponseDTO> obtenerVuelos(
            String empresa,
            String lugarLlegada,
            LocalDate fechaSalida,
            String ordenarPor,
            String orden) {

        Comparator<Vuelo> comparator = Comparator.comparing(Vuelo::getFechaSalida);

        switch (ordenarPor != null ? ordenarPor.toLowerCase() : "") {
            case "empresa" -> comparator = Comparator.comparing(Vuelo::getEmpresa);
            case "lugarllegada" -> comparator = Comparator.comparing(Vuelo::getLugarLlegada);
            case "fechallegada" -> comparator = Comparator.comparing(Vuelo::getFechaLlegada);
            default -> comparator = Comparator.comparing(Vuelo::getFechaSalida);
        }

        return repository.findAll().stream()
                .filter(v -> empresa == null || v.getEmpresa().equalsIgnoreCase(empresa))
                .filter(v -> lugarLlegada == null || v.getLugarLlegada().equalsIgnoreCase(lugarLlegada))
                .filter(v -> fechaSalida == null || v.getFechaSalida().equals(fechaSalida))
                .sorted(comparator)
                .map(v -> new VueloResponseDTO(
                        v.getId(),
                        v.getNombreVuelo(),
                        v.getEmpresa(),
                        v.getLugarSalida(),
                        v.getLugarLlegada(),
                        v.getFechaSalida(),
                        v.getFechaLlegada()))
                .collect(Collectors.toList());
    }

    public Vuelo obtenerPorId(int id) {
        Vuelo vuelo = repository.findById(id);
        if (vuelo == null) {
            throw new VueloNotFoundException(id);
        }
        return vuelo;
    }

    public Vuelo crear(Vuelo vuelo) {
        if (vuelo.getNombreVuelo() == null ||
                !FechaUtils.fechasValidas(vuelo.getFechaSalida(), vuelo.getFechaLlegada())) {
            throw new VueloBadRequestException("Datos del vuelo inválidos");
        }
        repository.save(vuelo);
        return vuelo;
    }

    public Vuelo actualizar(int id, Vuelo vuelo) {
        Vuelo existente = repository.findById(id);
        if (existente == null) {
            throw new VueloNotFoundException(id);
        }

        vuelo.setId(id);
        repository.delete(existente);
        repository.save(vuelo);
        return vuelo;
    }

    public void eliminar(int id) {
        Vuelo vuelo = repository.findById(id);
        if (vuelo == null) {
            throw new VueloNotFoundException(id);
        }
        repository.delete(vuelo);
    }
}