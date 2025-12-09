package com.apointment_service.vetTrack.domain.model;

import com.apointment_service.vetTrack.domain.exception.DomainException;
import com.apointment_service.vetTrack.domain.exception.IdlePetException;
import com.apointment_service.vetTrack.domain.exception.PetInvalidException;

public class Pet {
    private Long id;
    private String name;
    private Species species;
    private int age;
    private String ownerName;
    private String ownerDocument;
    private StatePet statePet;


    public Pet(String name, Species species, int age, String ownerDocument, String ownerName) {

        if (ownerDocument == null || ownerDocument.isBlank()){
            throw new PetInvalidException("Documento del dueño obligatorio");
        }
        if (age <= 0){
            throw new PetInvalidException("La edad debe ser mayor a 0");
        }

        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerDocument = ownerDocument;
        this.ownerName = ownerName;

        // Cuando un animal se crea: se crea activo
        this.statePet = StatePet.ACTIVA;
    }

    // Regla de negocio
    public void validateCanRequestAppointment(){
        if (this.statePet != StatePet.ACTIVA){
            throw new IdlePetException();
        }
    }

    public void desactivate(){
        this.statePet = StatePet.INACTIVA;
    }

    public void activate(){
        this.statePet = StatePet.ACTIVA;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Species getSpecies() {
        return species;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerDocument() {
        return ownerDocument;
    }

    public StatePet getStatePet() {
        return statePet;
    }
}
