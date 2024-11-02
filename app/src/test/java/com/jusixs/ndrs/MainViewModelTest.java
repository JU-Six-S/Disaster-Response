package com.jusixs.ndrs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jusixs.ndrs.data.model.Notification;
import com.jusixs.ndrs.data.repository.NotificationRepository;
import com.jusixs.ndrs.ui.viewmodel.MainViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainViewModelTest
{
    private MainViewModel viewModel;

    @Mock
    private NotificationRepository mockRepository;

    @Before
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
        viewModel = new MainViewModel(mockRepository);
    }

    /**
     * Tests the retrieval of notification LiveData.
     */
    @Test
    public void testGetNotificationLiveData()
    {
        // Arrange
        Notification notification = new Notification("Test Disaster", "Test Area", "Test Status", System.currentTimeMillis());
        MutableLiveData<Notification> liveData = new MutableLiveData<>();
        liveData.setValue(notification);

        when(mockRepository.getNotification()).thenReturn(liveData);

        // Act
        Observer<Notification> observer = new Observer<Notification>()
        {
            @Override
            public void onChanged(Notification notification)
            {
                assertEquals("Test Disaster", notification.getDisasterType());
            }
        };
        viewModel.getNotificationLiveData().observeForever(observer);
    }

    /**
     * Tests the save notification functionality.
     */
    @Test
    public void testSaveNotification()
    {
        // Arrange
        Notification notification = new Notification("Test Disaster", "Test Area", "Test Status", System.currentTimeMillis());

        // Act
        viewModel.saveNotification(notification);

        // Assert
        // Verify that saveNotification in the repository was called or check the state if necessary.
    }

    // Additional test cases...
}
