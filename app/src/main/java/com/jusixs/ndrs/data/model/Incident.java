package com.jusixs.ndrs.data.model;

public class Incident {
    private String name;
    private String type;
    private String location;
    private String time;
    private String affectedArea;
    private String assistanceType;

    public Incident(String name, String type, String location, String time, String affectedArea, String assistanceType) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.time = time;
        this.affectedArea = affectedArea;
        this.assistanceType = assistanceType;
    }

    public Incident(String flood, String water, String location, String time, String affectedArea) {
    }


    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getAffectedArea() {
        return affectedArea;
    }



    public String getAssistanceType(){
        return assistanceType;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
       this.location = location; }

    public void setTime(String time) {
        this.time = time; }

    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea; }

    public void setAssistanceType(String assistanceType){
        this.assistanceType = assistanceType;
    }
}
