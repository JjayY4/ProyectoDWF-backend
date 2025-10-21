package com.agencia.viajes.DTO;

import lombok.Data;

@Data
public class AirplaneDTO {
    private Integer idAirline;
    private String model;
    private String type;
    private Integer totalCapacity;
    private String description;
}