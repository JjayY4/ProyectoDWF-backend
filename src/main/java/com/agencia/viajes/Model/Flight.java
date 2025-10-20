package com.agencia.viajes.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Integer idFlight;
    @ManyToOne
    @JoinColumn(name = "id_airline", nullable = false)
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "id_route", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "id_airplane", nullable = false)
    private Airplane airplane;

    @Column(name = "flight_number", length = 10, nullable = false, unique = true)
    private String flightNumber;
    @Column(name = "departure_date_time", nullable = false)
    private LocalDateTime departureDateTime;

    @Column(name = "arrival_date_time", nullable = false)
    private LocalDateTime arrivalDateTime;

    @Column(name = "base_rate", precision = 10, scale = 2, nullable = false)
    private BigDecimal baseRate;

    @Column(name = "state", length = 20, nullable = false)
    private String state = "Programado";
    @OneToMany(mappedBy = "flight")
    private List<Scale> scales = new ArrayList<>();

    @OneToMany(mappedBy = "flight")
    private List<Reserve> reserves = new ArrayList<>();
}
