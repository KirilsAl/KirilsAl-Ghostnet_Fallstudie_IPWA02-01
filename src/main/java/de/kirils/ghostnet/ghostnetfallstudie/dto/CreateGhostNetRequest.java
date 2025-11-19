package de.kirils.ghostnet.ghostnetfallstudie.dto;

public record CreateGhostNetRequest(
        double gpsLat,
        double gpsLon,
        double sizeEstimate,
        String name,
        String phone
) {}
