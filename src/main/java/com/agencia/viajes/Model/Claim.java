package com.agencia.viajes.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "claim")
@Data

public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_claim")
    private Integer idClaim;

    @ManyToOne
    @JoinColumn(name = "id_reserve", nullable = false)
    private Reserve reserve;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;
    @Column(name = "type", length = 30, nullable = false)
    private String type;

    @Column(name = "state", length = 20, nullable = false)
    private String state = "Abierto";

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();
}
