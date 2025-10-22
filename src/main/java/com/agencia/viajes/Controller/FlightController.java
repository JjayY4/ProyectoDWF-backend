package com.agencia.viajes.Controller;

import com.agencia.viajes.DTO.FlightDTO;
import com.agencia.viajes.DTO.FlightResponseDTO;
import com.agencia.viajes.Model.Flight;
import com.agencia.viajes.Service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {

    private final FlightService flightService;
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Flight> createFlight(@RequestBody FlightDTO dto) {
        Flight created = flightService.saveFlight(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlightsDTO());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}