package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Flight;
import com.agencia.viajes.Model.Scale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScaleRepository extends JpaRepository<Scale, Integer> {
    List<Scale> findByFlightOrderByStep(Flight flight);
}
