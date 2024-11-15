package com.example.ndrsshelterinformationsifat.data.model;

/**
 * Represents a shelter item with details such as address, capacity, contact, and category.
 */
public class ShelterItem {
    private String address;
    private String capacity;
    private String contact;
    private String category;

    /**
     * Constructs a ShelterItem with the specified details.
     * @param address the address of the shelter
     * @param capacity the capacity of the shelter
     * @param contact the contact information for the shelter
     * @param category the category of the shelter
     */
    public ShelterItem(String address, String capacity, String contact, String category) {
        this.address = address;
        this.capacity = capacity;
        this.contact = contact;
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getContact() {
        return contact;
    }

    public String getCategory() {
        return category;
    }
}
