package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByRoute_OriginAirportAndRoute_DestinationAirportAndDepartureDateTimeBetween(
            String origin, String destination, LocalDateTime start, LocalDateTime end);
}