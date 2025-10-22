package com.agencia.viajes.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airline")
@Data
public class Airline {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_airline")
    private Integer idAirline;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;
    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "iata_code", columnDefinition = "TEXT")
    private String iataCode;
    @OneToMany(mappedBy = "airline")
    private List<Airplane> airplanes = new ArrayList<>();

    @OneToMany(mappedBy = "airline")
    private List<Crew> crews = new ArrayList<>();
}
