// Report.java
package com.jusixs.ndrs.data.model;

public class Report {
    private String location;
    private String disasterType;
    private String severity;
    private String photoData;

    public Report(String location, String disasterType, String severity, String photoData) {
        this.location = location;
        this.disasterType = disasterType;
        this.severity = severity;
        this.photoData = photoData;
    }

    // Getters for each field
    public String getLocation() {
        return location;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getPhotoData() {
        return photoData;
    }
}
