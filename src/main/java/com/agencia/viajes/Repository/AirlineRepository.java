package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    Optional<Airline> findByIataCode(String iataCode);
    Optional<Airline> findByName(String name);
}