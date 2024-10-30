package com.jusixs.ndrs.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.model.DisasterNotification;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<DisasterNotification> notification = new MutableLiveData<>();
    private final MutableLiveData<String> toastMessage = new MutableLiveData<>();

    public LiveData<DisasterNotification> getNotification() {
        return notification;
    }

    public LiveData<String> getToastMessage() {
        return toastMessage;
    }

    public void saveDraft(String disasterType, String affectedAreas, String currentStatus, String timestamp, String urgentMessage) {
        DisasterNotification draft = new DisasterNotification(disasterType, affectedAreas, currentStatus, timestamp, urgentMessage);
        notification.setValue(draft);
        toastMessage.setValue("Draft saved successfully!");
    }

    public void sendNotification() {
        if (notification.getValue() != null) {
            toastMessage.setValue("Notification sent successfully!");
        }
    }
}