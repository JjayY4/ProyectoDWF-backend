package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    Optional<Passenger> findByPassportNumber(String passportNumber);
    Optional<Passenger> findByEmail(String email);
}