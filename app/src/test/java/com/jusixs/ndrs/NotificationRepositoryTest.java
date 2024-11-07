package com.jusixs.ndrs.data.repository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jusixs.ndrs.data.model.Notification;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NotificationRepositoryTest
{
    private NotificationRepository notificationRepository;

    @Before
    public void setUp() {

        notificationRepository = new NotificationRepository();
    }

    /**
     * Tests that getNotification returns a MutableLiveData instance.
     */
    @Test
    public void testGetNotificationReturnsLiveData() {
        // Act
        MutableLiveData<Notification> result = notificationRepository.getNotification();

        // Assert
        assertEquals(result, notificationRepository.getNotification());
    }

    /**
     * Tests that saving a notification updates the LiveData.
     */
    @Test
    public void testSaveNotificationUpdatesLiveData() {
        // Arrange
        Notification notification = new Notification("Flood", "Area 51", "Critical", "Current Timestamp", "Evacuate immediately.");
        Observer<Notification> observer = mock(Observer.class);

        // Act
        notificationRepository.getNotification().observeForever(observer);
        notificationRepository.saveNotification(notification);

        // Assert
        verify(observer).onChanged(notification);
        assertEquals(notification, notificationRepository.getNotification().getValue());
    }

    /**
     * Tests that sending a notification updates the LiveData.
     */
    @Test
    public void testSendNotificationUpdatesLiveData() {
        // Arrange
        Notification notification = new Notification("Earthquake", "California", "Severe", "Current Timestamp", "Seek shelter immediately.");
        Observer<Notification> observer = mock(Observer.class);

        // Act
        notificationRepository.getNotification().observeForever(observer);
        notificationRepository.sendNotification(notification);

        // Assert
        verify(observer).onChanged(notification);
        assertEquals(notification, notificationRepository.getNotification().getValue());
    }
}
