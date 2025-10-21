package com.agencia.viajes.DTO;

import lombok.Data;

@Data
public class AirlineDTO {
    private String name;
    private String imageUrl;
    private String description;
    private String iataCode;
}