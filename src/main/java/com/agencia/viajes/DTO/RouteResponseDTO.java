package com.agencia.viajes.DTO;

import lombok.Data;

@Data
public class RouteResponseDTO {
    private Integer idRoute;
    private String originCity;
    private String originAirport;
    private String destinationCity;
    private String destinationAirport;
    private String code;
    private Double distanceKm;
    private Double estimatedDuration;
}