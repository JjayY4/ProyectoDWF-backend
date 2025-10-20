package com.agencia.viajes.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "crew")
@Data

public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_crew_member")
    private Integer idCrewMember;

    @ManyToOne
    @JoinColumn(name = "id_airline", nullable = false)
    private Airline airline;
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "nickname", length = 50, nullable = false)
    private String nickname;

    @Column(name = "post", length = 30, nullable = false)
    private String post;
    @Column(name = "license_number", length = 20, nullable = false, unique = true)
    private String licenseNumber;

    @Column(name = "available", nullable = false)
    private Boolean available = true;
}
