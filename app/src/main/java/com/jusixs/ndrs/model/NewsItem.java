package com.jusixs.ndrs.model;

public class NewsItem {
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private boolean isRedAlert;

    // Default constructor (required for Firestore)
    public NewsItem() { }

    // Constructor with parameters
    public NewsItem(String id, String title, String description, String imageUrl, boolean isRedAlert) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isRedAlert = isRedAlert;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Getter for Title
    public String getTitle() {
        return title;
    }

    // Getter for Description
    public String getDescription() {
        return description;
    }

    // Getter for Image URL
    public String getImageUrl() {
        return imageUrl;
    }

    // Getter for Red Alert status
    public boolean isRedAlert() {
        return isRedAlert;
    }

    // Setter for Red Alert status
    public void setRedAlert(boolean redAlert) {
        isRedAlert = redAlert;
    }
}
