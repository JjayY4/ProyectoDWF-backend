package com.agencia.viajes.Controller;

import com.agencia.viajes.DTO.*;
import com.agencia.viajes.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterPassengerRequestDTO dto) {
        authService.registerPassenger(dto);
        return ResponseEntity.ok("Usuario registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO dto) {
        LoginResponseDTO resp = authService.login(dto);
        return ResponseEntity.ok(resp);
    }
}