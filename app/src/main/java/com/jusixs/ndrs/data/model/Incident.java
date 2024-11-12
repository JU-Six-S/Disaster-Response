package com.jusixs.ndrs.data.model;

public class Incident {
    private String name;
    private String type;
    private String location;
    private String time;
    private String affectedArea;

    public Incident(String name, String type, String location, String time, String affectedArea) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.time = time;
        this.affectedArea = affectedArea;
    }

    // Getters
    public String getName() { return name; }
    public String getType() { return type; }
    public String getLocation() { return location; }
    public String getTime() { return time; }
    public String getAffectedArea() { return affectedArea; }
}
