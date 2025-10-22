package com.agencia.viajes.DTO;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private Integer idAirline;
    private Integer idRoute;
    private Integer idAirplane;
    private String flightNumber;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private BigDecimal baseRate;
}