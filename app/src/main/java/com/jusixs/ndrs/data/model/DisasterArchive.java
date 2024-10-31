package com.jusixs.ndrs.data.model;

/**
 * Model class representing a disaster archive entry in the National Disaster Response System (NDRS) project.
 * Holds details about a disaster event, including the title, date, and description.
 *
 * <p>This class provides getter methods for retrieving each attribute.</p>
 *
 * @author Sadman
 */
public class DisasterArchive {
    private String title;
    private String date;
    private String description;

    /**
     * Constructs a new {@code DisasterArchive} instance with specified title, date, and description.
     *
     * @param title       the title of the disaster event
     * @param date        the date of the disaster event in YYYY-MM-DD format
     * @param description a brief description of the disaster event
     */
    public DisasterArchive(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    /**
     * Gets the title of the disaster event.
     *
     * @return the title of the disaster event
     */
    public String getTitle() { return title; }

    /**
     * Gets the date of the disaster event.
     *
     * @return the date of the disaster event in YYYY-MM-DD format
     */
    public String getDate() { return date; }

    /**
     * Gets the description of the disaster event.
     *
     * @return a brief description of the disaster event
     */
    public String getDescription() { return description; }
}
