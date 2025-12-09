package com.apointment_service.vetTrack.application.port.in.comman;

public record RegisterCommand(String username, String password, String roleName) {
}
