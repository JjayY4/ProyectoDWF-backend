package com.agencia.viajes.Service;

import com.agencia.viajes.DTO.AirplaneDTO;
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

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public void deleteAirplane(Integer id) {
        airplaneRepository.deleteById(id);
    }
}