package com.agencia.viajes.Controller;

import com.agencia.viajes.DTO.AirplaneDTO;
import com.agencia.viajes.DTO.AirplaneResponseDTO;
import com.agencia.viajes.Model.Airplane;
import com.agencia.viajes.Service.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airplanes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AirplaneController {

    private final AirplaneService airplaneService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Airplane> createAirplane(@RequestBody AirplaneDTO dto) {
        return ResponseEntity.ok(airplaneService.saveAirplane(dto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AirplaneResponseDTO>> getAllAirplanes() {
        return ResponseEntity.ok(airplaneService.getAllAirplanesDTO());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAirplane(@PathVariable Integer id) {
        airplaneService.deleteAirplane(id);
        return ResponseEntity.noContent().build();
    }
}