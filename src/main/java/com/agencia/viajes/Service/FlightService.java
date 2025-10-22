package com.agencia.viajes.Service;

import com.agencia.viajes.DTO.FlightDTO;
import com.agencia.viajes.DTO.FlightResponseDTO;
import com.agencia.viajes.Model.Flight;
import com.agencia.viajes.Model.Airline;
import com.agencia.viajes.Model.Route;
import com.agencia.viajes.Model.Airplane;
import com.agencia.viajes.Repository.FlightRepository;
import com.agencia.viajes.Repository.AirlineRepository;
import com.agencia.viajes.Repository.RouteRepository;
import com.agencia.viajes.Repository.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirlineRepository airlineRepository;
    private final RouteRepository routeRepository;
    private final AirplaneRepository airplaneRepository;
    public Flight saveFlight(FlightDTO dto) {
        Airline airline = airlineRepository.findById(dto.getIdAirline())
                .orElseThrow(() -> new RuntimeException("Aerolínea no encontrada"));

        Route route = routeRepository.findById(dto.getIdRoute())
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

        Airplane airplane = airplaneRepository.findById(dto.getIdAirplane())
                .orElseThrow(() -> new RuntimeException("Avión no encontrado"));

        Flight flight = new Flight();
        flight.setAirline(airline);
        flight.setRoute(route);
        flight.setAirplane(airplane);
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setDepartureDateTime(dto.getDepartureDateTime());
        flight.setArrivalDateTime(dto.getArrivalDateTime());
        flight.setBaseRate(dto.getBaseRate());

        return flightRepository.save(flight);
    }
    public List<FlightResponseDTO> getAllFlightsDTO() {
        return flightRepository.findAll()
                .stream()
                .map(f -> {
                    FlightResponseDTO dto = new FlightResponseDTO();
                    dto.setIdFlight(f.getIdFlight());
                    dto.setFlightNumber(f.getFlightNumber());
                    dto.setDepartureDateTime(f.getDepartureDateTime());
                    dto.setArrivalDateTime(f.getArrivalDateTime());
                    dto.setBaseRate(f.getBaseRate());
                    dto.setState(f.getState());
                    dto.setAirlineName(f.getAirline().getName());
                    dto.setRouteCode(f.getRoute().getOriginAirport() + "-" + f.getRoute().getDestinationAirport());
                    dto.setAirplaneModel(f.getAirplane().getModel());
                    return dto;
                })
                .toList();
    }
    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }
}