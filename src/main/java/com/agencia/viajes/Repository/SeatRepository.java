package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Airplane;
import com.agencia.viajes.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByAirplaneAndAvailableTrue(Airplane airplane);
    Optional<Seat> findByAirplaneAndSeatNumber(Airplane airplane, String seatNumber);
}