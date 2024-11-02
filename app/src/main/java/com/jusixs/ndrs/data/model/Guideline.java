package com.jusixs.ndrs.data.model;

import androidx.annotation.NonNull;

/**
 * Represents a disaster management guideline.
 */
public class Guideline {

    private String id;
    private String incidentType;
    private String location;
    private String severity;
    private String content;
    private String lastUpdated;

    /**
     * Constructor for Guideline.
     *
     * @param id          the unique identifier of the guideline
     * @param incidentType the type of incident this guideline applies to (e.g., Flood, Cyclone)
     * @param location    the location where this guideline is applicable
     * @param severity    the severity level of the incident
     * @param content     the content of the guideline
     * @param lastUpdated the last updated date of the guideline
     */
    public Guideline(String id, String incidentType, String location, String severity, String content, String lastUpdated) {
        this.id = id;
        this.incidentType = incidentType;
        this.location = location;
        this.severity = severity;
        this.content = content;
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the unique identifier of the guideline.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the guideline.
     *
     * @param id the unique identifier of the guideline
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type of incident (e.g., Flood, Cyclone).
     */
    public String getIncidentType() {
        return incidentType;
    }

    /**
     * Sets the type of incident for this guideline.
     *
     * @param incidentType the type of incident (e.g., Flood, Cyclone)
     */
    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    /**
     * @return the location where this guideline is applicable.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location where this guideline is applicable.
     *
     * @param location the location where this guideline applies
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the severity level of the incident.
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the severity level of the incident.
     *
     * @param severity the severity level of the incident
     */
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * @return the content of the guideline.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the guideline.
     *
     * @param content the content of the guideline
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the last updated date of the guideline.
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the last updated date of the guideline.
     *
     * @param lastUpdated the last updated date of the guideline
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Provides a string representation of the guideline.
     *
     * @return a string representation of the guideline details
     */
    @NonNull
    @Override
    public String toString() {
        return "Guideline{" +
                "id='" + id + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", location='" + location + '\'' +
                ", severity='" + severity + '\'' +
                ", content='" + content + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }

    public String getType() {
        return "";
    }
}
