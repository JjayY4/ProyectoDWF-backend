package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> { }