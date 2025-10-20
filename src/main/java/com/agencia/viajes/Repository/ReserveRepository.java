package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Flight;
import com.agencia.viajes.Model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve, Integer> {
    Optional<Reserve> findByReserveCode(String reserveCode);
    List<Reserve> findByFlight(Flight flight);
}