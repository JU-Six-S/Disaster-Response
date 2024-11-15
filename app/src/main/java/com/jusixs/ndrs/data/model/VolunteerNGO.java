package com.jusixs.ndrs.data.model;

public class VolunteerNGO {
    private String name;
    private String contact;
    private String expertise;
    private String availability;

    public VolunteerNGO() {}

    public VolunteerNGO(String name, String contact, String expertise, String availability) {
        this.name = name;
        this.contact = contact;
        this.expertise = expertise;
        this.availability = availability;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getExpertise() { return expertise; }
    public void setExpertise(String expertise) { this.expertise = expertise; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}
