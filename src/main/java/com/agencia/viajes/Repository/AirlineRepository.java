package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Integer> { }