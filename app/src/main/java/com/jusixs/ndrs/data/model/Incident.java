package com.jusixs.ndrs.data.model;

/**
 * Represents an Incident in the system.
 * This class stores the details of an incident including its name, type, location, time,
 * affected area, and assistance type.
 */
public class Incident {
    private String name;
    private String type;
    private String location;
    private String time;
    private String affectedArea;
    private String assistanceType;

    /**
     * Constructor to initialize an Incident object with the provided details.
     *
     * @param name          the name of the incident.
     * @param type          the type of the incident (e.g., flood, fire, etc.).
     * @param location      the location of the incident.
     * @param time          the time the incident occurred.
     * @param affectedArea  the area affected by the incident.
     * @param assistanceType the type of assistance needed for the incident.
     */
    public Incident(String name, String type, String location, String time, String affectedArea, String assistanceType) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.time = time;
        this.affectedArea = affectedArea;
        this.assistanceType = assistanceType;
    }

    /**
     * Constructor to initialize an Incident with the basic required parameters.
     * This constructor can be used for creating incidents with a simplified set of attributes.
     *
     * @param name         the name of the incident.
     * @param type         the type of the incident (e.g., flood, fire, etc.).
     * @param location     the location of the incident.
     * @param time         the time the incident occurred.
     * @param affectedArea the area affected by the incident.
     */
    public Incident(String name, String type, String location, String time, String affectedArea) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.time = time;
        this.affectedArea = affectedArea;
    }

    /**
     * Returns the name of the incident.
     *
     * @return the name of the incident.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the incident.
     *
     * @return the type of the incident (e.g., flood, fire, etc.).
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the location of the incident.
     *
     * @return the location of the incident.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the time of the incident.
     *
     * @return the time the incident occurred.
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns the affected area of the incident.
     *
     * @return the area affected by the incident.
     */
    public String getAffectedArea() {
        return affectedArea;
    }

    /**
     * Returns the type of assistance required for the incident.
     *
     * @return the type of assistance needed.
     */
    public String getAssistanceType() {
        return assistanceType;
    }

    // Setters

    /**
     * Sets the name of the incident.
     *
     * @param name the name of the incident.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the type of the incident.
     *
     * @param type the type of the incident (e.g., flood, fire, etc.).
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the location of the incident.
     *
     * @param location the location of the incident.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the time of the incident.
     *
     * @param time the time the incident occurred.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Sets the affected area of the incident.
     *
     * @param affectedArea the area affected by the incident.
     */
    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }

    /**
     * Sets the type of assistance needed for the incident.
     *
     * @param assistanceType the type of assistance needed.
     */
    public void setAssistanceType(String assistanceType) {
        this.assistanceType = assistanceType;
    }
}
