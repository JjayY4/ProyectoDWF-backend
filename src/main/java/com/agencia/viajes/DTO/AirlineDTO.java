package com.agencia.viajes.DTO;

public record AirlineDTO(
        Integer idAirline,
        String name,
        String description,
        String iataCode,
        String imageUrl) {}