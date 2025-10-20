package com.agencia.viajes.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false, unique = true)
    private String email;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String rol;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Passenger passenger;
}
