package com.agencia.viajes.Service;

import com.agencia.viajes.DTO.AirplaneDTO;
import com.agencia.viajes.DTO.AirplaneResponseDTO;
import com.agencia.viajes.Model.Airplane;
import com.agencia.viajes.Model.Airline;
import com.agencia.viajes.Repository.AirplaneRepository;
import com.agencia.viajes.Repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final AirlineRepository airlineRepository;

    public Airplane saveAirplane(AirplaneDTO dto) {
        Airline airline = airlineRepository.findById(dto.getIdAirline())
                .orElseThrow(() -> new RuntimeException("Aerolínea no encontrada"));

        Airplane airplane = new Airplane();
        airplane.setAirline(airline);
        airplane.setModel(dto.getModel());
        airplane.setType(dto.getType());
        airplane.setTotalCapacity(dto.getTotalCapacity());
        airplane.setDescription(dto.getDescription());

        return airplaneRepository.save(airplane);
    }


    public List<AirplaneResponseDTO> getAllAirplanesDTO() {
        return airplaneRepository.findAll()
                .stream()
                .map(a -> {
                    AirplaneResponseDTO dto = new AirplaneResponseDTO();
                    dto.setIdAirplane(a.getIdAirplane());
                    dto.setModel(a.getModel());
                    dto.setType(a.getType());
                    dto.setTotalCapacity(a.getTotalCapacity());
                    dto.setDescription(a.getDescription());
                    dto.setAirlineName(a.getAirline().getName());
                    return dto;
                })
                .toList();
    }

    public void deleteAirplane(Integer id) {
        airplaneRepository.deleteById(id);
    }
}