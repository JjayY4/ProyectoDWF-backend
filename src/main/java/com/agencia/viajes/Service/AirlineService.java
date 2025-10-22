package com.agencia.viajes.Service;

import com.agencia.viajes.DTO.AirlineDTO;
import com.agencia.viajes.Model.Airline;
import com.agencia.viajes.Repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public Airline saveAirline(Airline airline) {
        if (airlineRepository.findByIataCode(airline.getIataCode()).isPresent()) {
            throw new RuntimeException("El código IATA ya existe");
        }

        if (airlineRepository.findByName(airline.getName()).isPresent()) {
            throw new RuntimeException("El nombre de la aerolínea ya existe");
        }

        return airlineRepository.save(airline);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public List<AirlineDTO> getAllAirlinesDTO() {
        return getAllAirlines()
                .stream()
                .map(a -> new AirlineDTO(
                        a.getIdAirline(),
                        a.getName(),
                        a.getDescription(),
                        a.getIataCode(),
                        a.getImageUrl()))
                .toList();
    }

    public Airline getAirlineById(Integer id) {
        return airlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aerolínea no encontrada con id: " + id));
    }

    public Airline updateAirline(Integer id, Airline airlineDetails) {
        Airline airline = getAirlineById(id);

        if (!airline.getIataCode().equals(airlineDetails.getIataCode())) {
            Optional<Airline> existingByIata = airlineRepository.findByIataCode(airlineDetails.getIataCode());
            if (existingByIata.isPresent() && !existingByIata.get().getIdAirline().equals(id)) {
                throw new RuntimeException("El código IATA ya existe");
            }
        }
        if (!airline.getName().equals(airlineDetails.getName())) {
            Optional<Airline> existingByName = airlineRepository.findByName(airlineDetails.getName());
            if (existingByName.isPresent() && !existingByName.get().getIdAirline().equals(id)) {
                throw new RuntimeException("El nombre de la aerolínea ya existe");
            }
        }

        airline.setName(airlineDetails.getName());
        airline.setImageUrl(airlineDetails.getImageUrl());
        airline.setDescription(airlineDetails.getDescription());
        airline.setIataCode(airlineDetails.getIataCode());

        return airlineRepository.save(airline);
    }

    public void deleteAirline(Integer id) {
        Airline airline = getAirlineById(id);
        airlineRepository.delete(airline);
    }
}