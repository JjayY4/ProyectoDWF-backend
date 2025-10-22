package com.agencia.viajes.DTO;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FlightResponseDTO {
    private Integer idFlight;
    private String flightNumber;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private BigDecimal baseRate;
    private String state;
    private String airlineName;
    private String routeCode;
    private String airplaneModel;
}