package com.jusixs.ndrs.data.model;

public class DisasterArchive {
    private String title;
    private String date;
    private String description;

    public DisasterArchive(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getDescription() { return description; }
}
