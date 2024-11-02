package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.Notification;
import com.jusixs.ndrs.ui.viewmodel.MainViewModel;

/**
 * Activity class for managing notifications related to disasters.
 */
public class NotificationActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    /**
     * Initializes the activity, setting up the ViewModel and observing toast messages.
     *
     * @param savedInstanceState If the activity is being re-initialized, this parameter
     *                           contains data most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Observe the toast message
        viewModel.getToastMessage().observe(this, message -> {
            if (message != null) {
                showToastMessage(message);
            }
        });
    }

    /**
     * Saves a draft notification with predefined data.
     */
    public void saveDraft() {
        Notification draftNotification = createNotification(
                "Flood",           // nature of disaster
                "Area 51",        // affected area
                "Severe",         // current status
                "Current Timestamp", // timestamp
                "Evacuate immediately." // instructions
        );

        viewModel.saveNotification(draftNotification);
    }

    /**
     * Sends a notification with predefined data.
     */
    private void sendNotification() {
        Notification notification = createNotification(
                "Flood",           // nature of disaster
                "Area 51",        // affected area
                "Severe",         // current status
                "Current Timestamp", // timestamp
                "Evacuate immediately." // instructions
        );

        viewModel.sendNotification(notification); // Pass the Notification object here
    }

    /**
     * Shows a toast message on the screen.
     *
     * @param message The message to display.
     */
    private void showToastMessage(String message) {
        Toast.makeText(NotificationActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Creates a Notification object with the given parameters.
     *
     * @param disasterType  The type of disaster.
     * @param affectedAreas The areas affected by the disaster.
     * @param currentStatus The current status of the disaster.
     * @param timestamp     The timestamp of the notification.
     * @param urgentMessage The urgent message to be conveyed.
     * @return A Notification object.
     */
    private Notification createNotification(String disasterType, String affectedAreas, String currentStatus,
                                            String timestamp, String urgentMessage) {
        return new Notification(disasterType, affectedAreas, currentStatus, timestamp, urgentMessage);
    }
}
