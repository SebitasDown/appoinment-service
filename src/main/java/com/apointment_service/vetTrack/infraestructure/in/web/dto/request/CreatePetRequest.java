package com.apointment_service.vetTrack.infraestructure.in.web.dto.request;

import com.apointment_service.vetTrack.domain.model.Species;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CreatePetRequest {
    private String name;
    private String ownerName;
    private String ownerDocument;
    private int age;
    private Species species;
}
