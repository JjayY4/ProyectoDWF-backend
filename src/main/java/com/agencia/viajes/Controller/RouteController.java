package com.agencia.viajes.Controller;

import com.agencia.viajes.DTO.RouteDTO;
import com.agencia.viajes.DTO.RouteResponseDTO;
import com.agencia.viajes.Service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createRoute(@RequestBody RouteDTO dto) {
        return ResponseEntity.ok(routeService.saveRoute(dto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<RouteResponseDTO>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutesDTO());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRoute(@PathVariable Integer id) {
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}