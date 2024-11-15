package com.example.ndrsshelterinformationsifat.data.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShelterItemTest {

    @Test
    public void testGetAddress() {
        ShelterItem item = new ShelterItem("123 Main St", "100", "555-1234", "City Hall Shelter Hub");
        assertEquals("123 Main St", item.getAddress());
    }

    @Test
    public void testGetCapacity() {
        ShelterItem item = new ShelterItem("123 Main St", "100", "555-1234", "City Hall Shelter Hub");
        assertEquals("100", item.getCapacity());
    }

    @Test
    public void testGetContact() {
        ShelterItem item = new ShelterItem("123 Main St", "100", "555-1234", "City Hall Shelter Hub");
        assertEquals("555-1234", item.getContact());
    }

    @Test
    public void testGetCategory() {
        ShelterItem item = new ShelterItem("123 Main St", "100", "555-1234", "City Hall Shelter Hub");
        assertEquals("City Hall Shelter Hub", item.getCategory());
    }
}
