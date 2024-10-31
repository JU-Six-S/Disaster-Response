package com.jusixs.ndrs.model;

import java.io.Serializable;

/**
 * Model class representing a news item.
 * Implements Serializable for passing instances between components.
 */
public class NewsItem implements Serializable
{
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private boolean isRedAlert;

    /**
     * Default constructor required for Firestore.
     */
    public NewsItem()
    {
        // No-argument constructor
    }

    /**
     * Constructs a NewsItem with specified values.
     *
     * @param id           the unique identifier of the news item
     * @param title        the title of the news item
     * @param description  a brief description of the news item
     * @param imageUrl     the URL of the image associated with the news item
     * @param isRedAlert   indicates whether the news item is a red alert
     */
    public NewsItem(String id, String title, String description, String imageUrl, boolean isRedAlert)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isRedAlert = isRedAlert;
    }

    /**
     * Gets the unique identifier of the news item.
     *
     * @return the news item ID
     */
    public String getId()
    {
        return id;
    }

    /**
     * Gets the title of the news item.
     *
     * @return the news item title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the description of the news item.
     *
     * @return the news item description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Gets the URL of the image associated with the news item.
     *
     * @return the news item image URL
     */
    public String getImageUrl()
    {
        return imageUrl;
    }

    /**
     * Checks if the news item is marked as a red alert.
     *
     * @return true if it is a red alert, false otherwise
     */
    public boolean isRedAlert()
    {
        return isRedAlert;
    }

    /**
     * Sets the red alert status of the news item.
     *
     * @param redAlert the new red alert status
     */
    public void setRedAlert(boolean redAlert)
    {
        isRedAlert = redAlert;
    }

    /**
     * Sets the title of the news item.
     *
     * @param title the new title for the news item
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Sets the description of the news item.
     *
     * @param description the new description for the news item
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Sets the image URL for the news item.
     *
     * @param imageUrl the new image URL for the news item
     */
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
}
