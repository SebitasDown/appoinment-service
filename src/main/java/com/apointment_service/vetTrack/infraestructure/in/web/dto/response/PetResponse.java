package com.apointment_service.vetTrack.infraestructure.in.web.dto.response;

import com.apointment_service.vetTrack.domain.model.Species;
import com.apointment_service.vetTrack.domain.model.StatePet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PetResponse {
    private Long id;
    private String name;
    private String ownerName;
    private String ownerDocument;
    private int age;
    private Species species;
    private StatePet statePet;

}
