package com.agencia.viajes.Controller;

import com.agencia.viajes.DTO.AirlineDTO;
import com.agencia.viajes.Model.Airline;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import com.agencia.viajes.Service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AirlineController {

    private final AirlineService airlineService;
    @Autowired
    private Cloudinary cloudinary;
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Airline> createAirline(@RequestBody AirlineDTO airlineDTO) {
        Airline airline = new Airline();
        airline.setName(airlineDTO.getName());
        airline.setImageUrl(airlineDTO.getImageUrl());
        airline.setDescription(airlineDTO.getDescription());
        airline.setIataCode(airlineDTO.getIataCode());

        Airline savedAirline = airlineService.saveAirline(airline);
        return ResponseEntity.ok(savedAirline);
    }

    @GetMapping
    public ResponseEntity<List<Airline>> getAllAirlines() {
        List<Airline> airlines = airlineService.getAllAirlines();
        return ResponseEntity.ok(airlines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Integer id) {
        Airline airline = airlineService.getAirlineById(id);
        return ResponseEntity.ok(airline);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Airline> updateAirline(@PathVariable Integer id, @RequestBody AirlineDTO airlineDTO) {
        Airline airlineDetails = new Airline();
        airlineDetails.setName(airlineDTO.getName());
        airlineDetails.setImageUrl(airlineDTO.getImageUrl());
        airlineDetails.setDescription(airlineDTO.getDescription());
        airlineDetails.setIataCode(airlineDTO.getIataCode());

        Airline updatedAirline = airlineService.updateAirline(id, airlineDetails);
        return ResponseEntity.ok(updatedAirline);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAirline(@PathVariable Integer id) {
        airlineService.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        System.out.println("=== INICIANDO UPLOAD DE IMAGEN ===");
        System.out.println("Archivo: " + file.getOriginalFilename() + " - Tamaño: " + file.getSize() + " - Tipo: " + file.getContentType());

        try {
            // Validaciones
            if (file.isEmpty()) {
                System.out.println("ERROR: Archivo vacío");
                return ResponseEntity.badRequest().body("Archivo vacío");
            }

            if (file.getSize() > 2_000_000) {
                System.out.println("ERROR: Archivo muy grande - " + file.getSize());
                return ResponseEntity.badRequest().body("Tamaño máximo 2 MB");
            }

            if (!Set.of("image/jpeg","image/png","image/webp").contains(file.getContentType())) {
                System.out.println("ERROR: Formato no permitido - " + file.getContentType());
                return ResponseEntity.badRequest().body("Formato no permitido");
            }

            System.out.println("Configurando parámetros de Cloudinary...");
            Map<String, Object> params = ObjectUtils.asMap(
                    "folder", "aerolineas",
                    "upload_preset", "aerolineas_unsigned",
                    "resource_type", "image",
                    "unsigned", true
            );

            System.out.println("Subiendo a Cloudinary...");
            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), params);
            System.out.println("Upload exitoso: " + result);

            String url = result.get("secure_url").toString();
            System.out.println("URL obtenida: " + url);

            return ResponseEntity.ok(Map.of("url", url));

        } catch (IOException e) {
            System.out.println("ERROR IOException: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al procesar la imagen: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR General: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error del servidor: " + e.getMessage());
        }
    }


}