package com.jusixs.ndrs.data.model;

public class Volunteer {
    private String name;
    private String contact;
    private String expertise;
    private String availability;

    public Volunteer(String name, String contact, String expertise, String availability) {
        this.name = name;
        this.contact = contact;
        this.expertise = expertise;
        this.availability = availability;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getAvailability() {
        return availability;
    }
}
