package com.agencia.viajes.Service;

import com.agencia.viajes.DTO.RouteDTO;
import com.agencia.viajes.DTO.RouteResponseDTO;
import com.agencia.viajes.Model.Route;
import com.agencia.viajes.Repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    public Route saveRoute(RouteDTO dto) {
        Route route = new Route();
        route.setOriginCity(dto.getOriginCity());
        route.setOriginAirport(dto.getOriginAirport());
        route.setDestinationCity(dto.getDestinationCity());
        route.setDestinationAirport(dto.getDestinationAirport());
        route.setDistanceKm(dto.getDistanceKm());
        route.setEstimatedDuration(dto.getEstimatedDuration());
        return routeRepository.save(route);
    }

    public List<RouteResponseDTO> getAllRoutesDTO() {
        return routeRepository.findAll()
                .stream()
                .map(r -> {
                    RouteResponseDTO dto = new RouteResponseDTO();
                    dto.setIdRoute(r.getIdRoute());
                    dto.setOriginCity(r.getOriginCity());
                    dto.setOriginAirport(r.getOriginAirport());
                    dto.setDestinationCity(r.getDestinationCity());
                    dto.setDestinationAirport(r.getDestinationAirport());
                    dto.setCode(r.getOriginAirport() + "-" + r.getDestinationAirport());
                    dto.setDistanceKm(r.getDistanceKm().doubleValue());
                    dto.setEstimatedDuration(r.getEstimatedDuration().doubleValue());
                    return dto;
                })
                .toList();
    }

    public void deleteRoute(Integer id) {
        routeRepository.deleteById(id);
    }
}