package com.agencia.viajes.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "scale")
@Data
public class Scale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_scale")
    private Integer idScale;

    @ManyToOne
    @JoinColumn(name = "id_flight", nullable = false)
    private Flight flight;
    @Column(name = "airport_scale", length = 3, nullable = false)
    private String airportScale;

    @Column(name = "city_scale", length = 50, nullable = false)
    private String cityScale;

    @Column(name = "country", length = 50, nullable = false)
    private String country;

    @Column(name = "step", nullable = false)
    private Integer step;

    @Column(name = "duration", nullable = false)
    private LocalTime duration;
}
