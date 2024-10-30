package com.jusixs.ndrs.model;


public class DisasterNotification {
    private String disasterType;
    private String affectedAreas;
    private String currentStatus;
    private String timestamp;
    private String urgentMessage;

    public DisasterNotification(String disasterType, String affectedAreas, String currentStatus, String timestamp, String urgentMessage) {
        this.disasterType = disasterType;
        this.affectedAreas = affectedAreas;
        this.currentStatus = currentStatus;
        this.timestamp = timestamp;
        this.urgentMessage = urgentMessage;
    }

    // Getters and setters for each field
}

