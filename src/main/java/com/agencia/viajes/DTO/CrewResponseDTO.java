package com.agencia.viajes.DTO;

import lombok.Data;

@Data
public class CrewResponseDTO {
    private Integer idCrewMember;
    private String name;
    private String nickname;
    private String post;
    private String licenseNumber;
    private String airlineName;
}