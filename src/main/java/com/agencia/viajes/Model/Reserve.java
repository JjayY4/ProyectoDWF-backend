package com.agencia.viajes.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESERVE")
@Data
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserve")
    private Integer idReserve;

    @ManyToOne
    @JoinColumn(name = "id_flight", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_passenger", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "id_seat", nullable = false)
    private Seat seat;

    @Column(name = "reserve_code", length = 6, nullable = false, unique = true)
    private String reserveCode;

    @Column(name = "date_reserve", nullable = false)
    private LocalDateTime dateReserve = LocalDateTime.now();

    @Column(name = "state_reserve", length = 20, nullable = false)
    private String stateReserve = "Pendiente";

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @OneToOne(mappedBy = "reserve")
    private Payment payment;

    @OneToMany(mappedBy = "reserve")
    private List<Claim> claims = new ArrayList<>();
}