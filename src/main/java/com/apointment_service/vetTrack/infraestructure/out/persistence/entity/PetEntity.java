package com.apointment_service.vetTrack.infraestructure.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pets")
@Data
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerDocument;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String statePet;

}

