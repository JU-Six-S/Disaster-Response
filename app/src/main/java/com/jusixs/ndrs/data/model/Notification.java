package com.jusixs.ndrs.data.model;

public class Notification {
    private final String disasterType;
    private final String affectedAreas;
    private final String currentStatus;
    private final String timestamp;
    private final String urgentMessage;

    /**
     * Constructor to create a new Notification instance.
     *
     * @param disasterType   The type of disaster.
     * @param affectedAreas  Areas affected by the disaster.
     * @param currentStatus  Current status of the disaster.
     * @param timestamp      Timestamp of the notification.
     * @param urgentMessage  Urgent message associated with the notification.
     */
    public Notification(String disasterType, String affectedAreas, String currentStatus, String timestamp, String urgentMessage) {
        this.disasterType = disasterType;
        this.affectedAreas = affectedAreas;
        this.currentStatus = currentStatus;
        this.timestamp = timestamp;
        this.urgentMessage = urgentMessage;
    }

    /**
     * Test constructor for creating a Notification instance with test parameters.
     *
     * @param testDisaster   The test disaster type.
     * @param testArea       The test affected area.
     * @param testStatus     The test current status.
     * @param timestamp      The test timestamp.
     */
    public Notification(String testDisaster, String testArea, String testStatus, long timestamp) {
        this.disasterType = testDisaster;
        this.affectedAreas = testArea;
        this.currentStatus = testStatus;
        this.timestamp = String.valueOf(timestamp); // Convert long to String for timestamp
        this.urgentMessage = ""; // Set a default value or handle as needed
    }

    // Getters
    public String getDisasterType()
    {
        return disasterType;
    }

    public String getAffectedAreas()
    {
        return affectedAreas;
    }

    public String getCurrentStatus()
    {
        return currentStatus;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public String getUrgentMessage()
    {
        return urgentMessage;
    }
}
