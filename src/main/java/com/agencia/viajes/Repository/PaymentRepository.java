package com.agencia.viajes.Repository;

import com.agencia.viajes.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> { }