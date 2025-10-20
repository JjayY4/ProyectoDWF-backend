package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Airline;
import com.agencia.viajes.Model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrewRepository extends JpaRepository<Crew, Integer> {
    List<Crew> findByAirlineAndAvailableTrue(Airline airline);
}