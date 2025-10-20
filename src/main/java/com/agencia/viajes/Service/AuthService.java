package com.agencia.viajes.Service;

import com.agencia.viajes.Configurations.JwtUtil;
import com.agencia.viajes.DTO.*;
import com.agencia.viajes.Model.Passenger;
import com.agencia.viajes.Model.User;
import com.agencia.viajes.Repository.PassengerRepository;
import com.agencia.viajes.Repository.UserRepository;
import com.agencia.viajes.Configurations.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final PassengerRepository passengerRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public void registerPassenger(RegisterPassengerRequestDTO dto) {
        if (userRepo.existsByEmail(dto.getEmail()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email ya existe");

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRol("PASSENGER");
        user = userRepo.save(user);

        Passenger p = new Passenger();
        p.setName(dto.getName());
        p.setBirthDate(dto.getBirthDate());
        p.setPassportNumber(dto.getPassportNumber());
        p.setEmail(dto.getEmail());
        p.setPhone(dto.getPhone());
        p.setUser(user);
        passengerRepo.save(p);
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        User u = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        if (!encoder.matches(dto.getPassword(), u.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        String token = jwtUtil.generateToken(u.getEmail(), u.getRol());
        return new LoginResponseDTO(token, u.getRol());
    }
}
