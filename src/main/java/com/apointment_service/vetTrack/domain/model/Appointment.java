package com.apointment_service.vetTrack.domain.model;

import com.apointment_service.vetTrack.domain.exception.AppoimentInvalidException;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private Long id;
    private Pet pet;
    private Long veterinarianId;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    private AppointmentStatus status;
    private String diagnosis;

    public Appointment(Pet pet, Long veterinarianId, LocalDate date, LocalTime time, String reason) {

        if (pet == null){
            throw new AppoimentInvalidException("El motivo es obligatirio");
        }


        this.pet = pet;
        this.veterinarianId = veterinarianId;
        this.date = date;
        this.time = time;
        this.reason = reason;

        // Regla: una cita siempre inicia en pendiente
        this.status = AppointmentStatus.PENDIENTE;
    }

    public void confirm(){
        if (this.status == AppointmentStatus.CANCELADA){
            throw new AppoimentInvalidException("No se puede confirmar una cita cancelada");
        }
        this.status = AppointmentStatus.CONFIRMADA;
    }

    public void cancel(){
        this.status = AppointmentStatus.CANCELADA;
    }

    public void addDiagnosis(String diagnosis){
        if (this.status != AppointmentStatus.CONFIRMADA){
            throw new AppoimentInvalidException("Solo citas confirmadas pueden tener diagnostico");
        }

        if (diagnosis== null || diagnosis.isBlank()){
            throw new AppoimentInvalidException("Diagnostico invalido");
        }
        this.diagnosis = diagnosis;
    }

    public Long getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public Long getVeterinarianId() {
        return veterinarianId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
