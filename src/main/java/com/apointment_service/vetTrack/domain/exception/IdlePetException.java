package com.apointment_service.vetTrack.domain.exception;

public class IdlePetException extends DomainException{
    public IdlePetException(){
        // Estos nombre se le pueden dat a variables para que el manejador de excepciones sea más limpio
        super("La mascota debe estar Activa oara solicitar citas");
    }
}
