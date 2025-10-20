package com.agencia.viajes.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

public class RegisterRequestDTO {
    @Data
    public class RegisterRequest {
        @Email
        private String email;
        @Size(min = 6) private String password;
        @NotBlank
        private String name;
        @Past
        private LocalDate birthDate;
        @NotBlank private String passportNumber;
        @NotBlank private String phone;
    }
}
