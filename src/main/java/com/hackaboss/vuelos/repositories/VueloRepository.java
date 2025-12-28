
package com.hackaboss.vuelos.repositories;
import com.hackaboss.vuelos.models.Vuelo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VueloRepository {

    private final List<Vuelo> vuelos = new ArrayList<>();

    private int nextId = 11;

    @PostConstruct
    public void init() {

        vuelos.add(Vuelo.builder()
                .id(1)
                .nombreVuelo("H001-V")
                .empresa("Iberia")
                .lugarSalida("Madrid")
                .lugarLlegada("Buenos Aires")
                .fechaSalida(LocalDate.of(2025, 5, 20))
                .fechaLlegada(LocalDate.of(2025, 5, 20))
                .build());

        vuelos.add(Vuelo.builder()
                .id(2)
                .nombreVuelo("H002-V")
                .empresa("Singapore Airlines")
                .lugarSalida("Bangkok")
                .lugarLlegada("Nueva Delhi")
                .fechaSalida(LocalDate.of(2025, 7, 17))
                .fechaLlegada(LocalDate.of(2025, 7, 17))
                .build());

        vuelos.add(Vuelo.builder()
                .id(3)
                .nombreVuelo("H003-V")
                .empresa("Emirates")
                .lugarSalida("Londres")
                .lugarLlegada("Frankfurt")
                .fechaSalida(LocalDate.of(2025, 3, 14))
                .fechaLlegada(LocalDate.of(2025, 3, 14))
                .build());

        vuelos.add(Vuelo.builder()
                .id(4)
                .nombreVuelo("H004-V")
                .empresa("Qantas")
                .lugarSalida("Singapur")
                .lugarLlegada("Roma")
                .fechaSalida(LocalDate.of(2025, 4, 25))
                .fechaLlegada(LocalDate.of(2025, 4, 25))
                .build());

        vuelos.add(Vuelo.builder()
                .id(5)
                .nombreVuelo("H005-V")
                .empresa("Turkish Airlines")
                .lugarSalida("Atenas")
                .lugarLlegada("Estocolmo")
                .fechaSalida(LocalDate.of(2025, 8, 3))
                .fechaLlegada(LocalDate.of(2025, 8, 3))
                .build());

        vuelos.add(Vuelo.builder()
                .id(6)
                .nombreVuelo("H006-V")
                .empresa("Air Canada")
                .lugarSalida("Nueva York")
                .lugarLlegada("Barcelona")
                .fechaSalida(LocalDate.of(2025, 12, 31))
                .fechaLlegada(LocalDate.of(2026, 1, 1))
                .build());

        vuelos.add(Vuelo.builder()
                .id(7)
                .nombreVuelo("H007-V")
                .empresa("KLM Royal Dutch Airlines")
                .lugarSalida("Ámsterdam")
                .lugarLlegada("São Paulo")
                .fechaSalida(LocalDate.of(2025, 10, 22))
                .fechaLlegada(LocalDate.of(2025, 10, 22))
                .build());

        vuelos.add(Vuelo.builder()
                .id(8)
                .nombreVuelo("H008-V")
                .empresa("Japan Airlines")
                .lugarSalida("Tokio")
                .lugarLlegada("Los Ángeles")
                .fechaSalida(LocalDate.of(2025, 7, 21))
                .fechaLlegada(LocalDate.of(2025, 7, 22))
                .build());

        vuelos.add(Vuelo.builder()
                .id(9)
                .nombreVuelo("H009-V")
                .empresa("LATAM Airlines")
                .lugarSalida("Bogotá")
                .lugarLlegada("Santiago de Chile")
                .fechaSalida(LocalDate.of(2025, 3, 18))
                .fechaLlegada(LocalDate.of(2025, 3, 18))
                .build());

        vuelos.add(Vuelo.builder()
                .id(10)
                .nombreVuelo("H0010-V")
                .empresa("Qatar Airways")
                .lugarSalida("París")
                .lugarLlegada("Ciudad de México")
                .fechaSalida(LocalDate.of(2025, 3, 3))
                .fechaLlegada(LocalDate.of(2025, 3, 3))
                .build());
    }

    public List<Vuelo> findAll() {
        return new ArrayList<>(vuelos);
    }

    public Vuelo findById(int id) {
        return vuelos.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Vuelo vuelo) {
        if (vuelo.getId() == null) {   // verifica null
            vuelo.setId(nextId++);
        }
        vuelos.add(vuelo);
    }

    public void delete(Vuelo vuelo) {
        vuelos.remove(vuelo);
    }
}