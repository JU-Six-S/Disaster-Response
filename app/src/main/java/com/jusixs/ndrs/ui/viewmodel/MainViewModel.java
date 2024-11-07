package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jusixs.ndrs.data.model.Notification;
import com.jusixs.ndrs.data.repository.NotificationRepository;

public class MainViewModel extends ViewModel {
    private final NotificationRepository repository;
    private final LiveData<Notification> notificationLiveData;
    private final MutableLiveData<String> toastMessage; // MutableLiveData for toast messages

    /**
     * Constructor for MainViewModel.
     *
     * @param repository The NotificationRepository instance to handle notification data.
     */
    public MainViewModel(NotificationRepository repository) {
        this.repository = repository;
        notificationLiveData = repository.getNotification();
        toastMessage = new MutableLiveData<>();
    }

    /**
     * Returns the LiveData containing the current Notification.
     *
     * @return LiveData<Notification> The current notification data.
     */
    public LiveData<Notification> getNotificationLiveData() {

        return notificationLiveData;
    }

    /**
     * Saves the given notification using the repository.
     *
     * @param notification The Notification object to save.
     */
    public void saveNotification(Notification notification) {
        repository.saveNotification(notification);
    }

    /**
     * Sends the given notification using the repository and sets a toast message.
     *
     * @param notification The Notification object to send.
     */
    public void sendNotification(Notification notification) {
        repository.sendNotification(notification);
        // Set the toast message after sending the notification
        toastMessage.setValue("Notification sent!");
    }

    /**
     * Returns the LiveData containing the toast message.
     *
     * @return LiveData<String> The toast message to be displayed.
     */
    public LiveData<String> getToastMessage() {

        return toastMessage;
    }
}
