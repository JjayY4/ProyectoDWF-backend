package com.agencia.viajes.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class RegisterPassengerRequestDTO {
    @Email @NotBlank private String email;
    @Size(min = 6) @NotBlank private String password;
    @NotBlank private String name;
    @Past private LocalDate birthDate;
    @NotBlank private String passportNumber;
    @NotBlank private String phone;
}