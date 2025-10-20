package com.agencia.viajes.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "seat")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seat")
    private Integer idSeat;

    @ManyToOne
    @JoinColumn(name = "id_airplane", nullable = false)
    private Airplane airplane;

    @Column(name = "seat_number", length = 5, nullable = false)
    private String seatNumber;
    @Column(name = "class", length = 20, nullable = false)
    private String seatClass = "Económica";

    @Column(name = "available", nullable = false)
    private Boolean available = true;
}