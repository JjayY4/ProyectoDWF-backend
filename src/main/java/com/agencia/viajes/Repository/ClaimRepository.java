package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Claim;
import com.agencia.viajes.Model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    List<Claim> findByReserve(Reserve reserve);
}
