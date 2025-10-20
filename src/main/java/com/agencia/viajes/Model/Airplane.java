package com.agencia.viajes.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AIRPLANE")
@Data
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airplane")
    private Integer idAirplane;

    @ManyToOne
    @JoinColumn(name = "id_airline", nullable = false)
    private Airline airline;
    @Column(name = "model", length = 50, nullable = false)
    private String model;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "total_capacity", nullable = false)
    private Integer totalCapacity;

    @Column(name = "description", length = 50)
    private String description;

    @OneToMany(mappedBy = "airplane")
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "airplane")
    private List<Flight> flights = new ArrayList<>();
}