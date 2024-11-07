package com.jusixs.ndrs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.jusixs.ndrs.data.model.Notification; // Importing the correct Notification class

public class NotificationTest {
    /**
     * Tests the creation of a Notification object.
     */
    @Test
    public void testNotificationCreation() {
        // Given
        String disasterType = "Flood";
        String affectedAreas = "Area 51";
        String currentStatus = "Severe";
        String timestamp = "2024-11-02T10:00:00Z";
        String urgentMessage = "Evacuate immediately.";

        // When
        Notification notification = new Notification(disasterType, affectedAreas, currentStatus, timestamp, urgentMessage);

        // Then
        assertEquals(disasterType, notification.getDisasterType());
        assertEquals(affectedAreas, notification.getAffectedAreas());
        assertEquals(currentStatus, notification.getCurrentStatus());
        assertEquals(timestamp, notification.getTimestamp());
        assertEquals(urgentMessage, notification.getUrgentMessage());
    }

    /**
     * Tests the setter methods of the Notification object.
     */
    @Test
    public void testSetters() {
        // Given
        Notification notification = new Notification("Flood", "Area 51", "Severe", "2024-11-02T10:00:00Z", "Evacuate immediately.");

        // When
//        notification.setDisasterType("Earthquake");
//        notification.setAffectedAreas("Downtown");
//        notification.setCurrentStatus("Moderate");
//        notification.setTimestamp("2024-11-02T11:00:00Z");
//        notification.setUrgentMessage("Seek shelter.");

        // Then
        assertEquals("Earthquake", notification.getDisasterType());
        assertEquals("Downtown", notification.getAffectedAreas());
        assertEquals("Moderate", notification.getCurrentStatus());
        assertEquals("2024-11-02T11:00:00Z", notification.getTimestamp());
        assertEquals("Seek shelter.", notification.getUrgentMessage());
    }
}
