package com.jusixs.ndrs.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.jusixs.ndrs.data.model.Notification;

public class NotificationRepository {
    private final MutableLiveData<Notification> notificationLiveData = new MutableLiveData<>();

    /**
     * Retrieves the LiveData object that holds the current Notification.
     *
     * @return MutableLiveData containing the current Notification.
     */
    public MutableLiveData<Notification> getNotification() {

        return notificationLiveData;
    }

    /**
     * Saves the provided Notification as a draft.
     *
     * @param notification The Notification to save.
     */
    public void saveNotification(Notification notification) {
        // Save draft logic could go here.
        notificationLiveData.setValue(notification);
    }

    /**
     * Sends the provided Notification to the server or API.
     *
     * @param notification The Notification to send.
     */
    public void sendNotification(Notification notification) {
        // Logic for sending notification to a server or API.
        notificationLiveData.setValue(notification);
    }
}
