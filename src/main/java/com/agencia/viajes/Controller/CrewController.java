package com.agencia.viajes.Controller;

import com.agencia.viajes.DTO.CrewDTO;
import com.agencia.viajes.DTO.CrewResponseDTO;
import com.agencia.viajes.Model.Crew;
import com.agencia.viajes.Service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crew")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CrewController {

    private final CrewService crewService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Crew> createCrew(@RequestBody CrewDTO dto) {
        Crew created = crewService.saveCrew(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CrewResponseDTO>> getAllCrew() {
        return ResponseEntity.ok(crewService.getAllCrewDTO());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCrew(@PathVariable Integer id) {
        crewService.deleteCrew(id);
        return ResponseEntity.noContent().build();
    }
}
