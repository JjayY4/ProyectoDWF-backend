package com.agencia.viajes.DTO;

import lombok.Data;

@Data
public class AirplaneResponseDTO {
    private Integer idAirplane;
    private String model;
    private String type;
    private Integer totalCapacity;
    private String description;
    private String airlineName;
}