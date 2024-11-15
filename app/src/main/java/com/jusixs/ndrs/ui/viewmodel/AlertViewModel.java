package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jusixs.ndrs.data.model.Alert;
import com.jusixs.ndrs.data.repository.AlertRepository;

/**
 * ViewModel to manage alert sending and status updating.
 */
public class AlertViewModel extends ViewModel {
    private final AlertRepository repository;
    private final MutableLiveData<String> alertStatus = new MutableLiveData<>();

    /**
     * Constructor to initialize repository.
     *
     * @param repository The repository to interact with the alert data.
     */
    public AlertViewModel(AlertRepository repository) {
        this.repository = repository;
        alertStatus.setValue(null); // Set initial status as null or "pending"
    }

    /**
     * Returns the LiveData of the alert status.
     *
     * @return The LiveData holding the status of the alert.
     */
    public LiveData<String> getAlertStatus() {
        return alertStatus;
    }

    /**
     * Sends an alert using the repository and updates the status LiveData.
     *
     * @param type       The type of the alert (e.g., "emergency", "general").
     * @param message    The message content of the alert.
     * @param audience   The target audience for the alert.
     * @param priority   The priority level of the alert (e.g., "high", "normal").
     * @param location   The location related to the alert.
     */
    public void sendAlert(String type, String message, String audience, String priority, String location) {
        Alert alert = new Alert();
        alert.setType(type);
        alert.setMessage(message);
        alert.setAudience(audience);
        alert.setPriority(priority);
        alert.setLocation(location);

        try {
            // Call repository to send the alert
            Alert result = repository.sendAlert(alert);
            // Set the alert status based on the result
            alertStatus.setValue(result.getStatus());
        } catch (Exception e) {
            // In case of error (e.g., network issues), set status to "failed"
            alertStatus.setValue("failed");
        }
    }
}
