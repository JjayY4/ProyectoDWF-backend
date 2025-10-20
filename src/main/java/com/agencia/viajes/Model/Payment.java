package com.agencia.viajes.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Integer idPayment;

    @OneToOne
    @JoinColumn(name = "id_reserve", nullable = false)
    private Reserve reserve;

    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_method", length = 20, nullable = false)
    private String paymentMethod;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate = LocalDateTime.now();
    @Column(name = "state_payment", length = 20, nullable = false)
    private String statePayment = "Pendiente";

    @Column(name = "transaction_code", length = 50)
    private String transactionCode;
}