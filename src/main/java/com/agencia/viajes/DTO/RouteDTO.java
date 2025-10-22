package com.agencia.viajes.DTO;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RouteDTO {
    private String originCity;
    private String originAirport;
    private String destinationCity;
    private String destinationAirport;
    private BigDecimal distanceKm;
    private BigDecimal estimatedDuration;
}