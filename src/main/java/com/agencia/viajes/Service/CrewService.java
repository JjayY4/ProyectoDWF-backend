package com.agencia.viajes.Service;

import com.agencia.viajes.DTO.CrewDTO;
import com.agencia.viajes.Model.Crew;
import com.agencia.viajes.Model.Airline;
import com.agencia.viajes.Repository.CrewRepository;
import com.agencia.viajes.Repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrewService {
    private final CrewRepository crewRepository;
    private final AirlineRepository airlineRepository;

    public Crew saveCrew(CrewDTO dto) {
        Airline airline = airlineRepository.findById(dto.getIdAirline())
                .orElseThrow(() -> new RuntimeException("Aerolínea no encontrada"));

        Crew crew = new Crew();
        crew.setAirline(airline);
        crew.setName(dto.getName());
        crew.setNickname(dto.getNickname());
        crew.setPost(dto.getPost());
        crew.setLicenseNumber(dto.getLicenseNumber());

        return crewRepository.save(crew);
    }

    public List<Crew> getAllCrew() {
        return crewRepository.findAll();
    }

    public void deleteCrew(Integer id) {
        crewRepository.deleteById(id);
    }
}