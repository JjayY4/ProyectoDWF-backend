package com.agencia.viajes.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Entity
@Table(name = "route")
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_route")
    private Integer idRoute;

    @Column(name = "destination_city", length = 100, nullable = false)
    private String destinationCity;

    @Column(name = "distance_km", precision = 10, scale = 2, nullable = false)
    private BigDecimal distanceKm;
    @Column(name = "origin_airport", length = 3, nullable = false)
    private String originAirport;

    @Column(name = "origin_city", length = 100, nullable = false)
    private String originCity;
    @Column(name = "estimated_duration", precision = 4, scale = 2, nullable = false)
    private BigDecimal estimatedDuration;

    @Column(name = "destination_airport", length = 3, nullable = false)
    private String destinationAirport;
}
