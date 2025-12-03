package com.apointment_service.vetTrack;

import org.springframework.boot.SpringApplication;

public class TestVetTrackApplication {

	public static void main(String[] args) {
		SpringApplication.from(VetTrackApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
