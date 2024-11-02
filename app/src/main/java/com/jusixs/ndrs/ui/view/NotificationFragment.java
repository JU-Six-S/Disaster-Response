package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.Notification;
import com.jusixs.ndrs.ui.viewmodel.MainViewModel;

/**
 * Fragment for displaying notifications related to disasters.
 */
public class NotificationFragment extends Fragment {

    private MainViewModel viewModel;

    /**
     * Inflates the fragment layout and initializes the ViewModel.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment.
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state.
     * @return The View for the fragment's UI.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Observe the toast message
        observeToastMessage();

        // Handle button click for sending notification
        setupSendNotificationButton(view);

        return view;
    }

    /**
     * Sets up the button to send notifications.
     *
     * @param view The view containing the button.
     */
    private void setupSendNotificationButton(View view) {
        view.findViewById(R.id.buttonSendNotification).setOnClickListener(v -> sendNotification());
    }

    /**
     * Observes toast messages from the ViewModel and displays them.
     */
    private void observeToastMessage() {
        viewModel.getToastMessage().observe(getViewLifecycleOwner(), message -> {
            if (message != null) {
                showToastMessage(message);
            }
        });
    }

    /**
     * Shows a toast message on the screen.
     *
     * @param message The message to display.
     */
    private void showToastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Creates a Notification object with predefined data and sends it.
     */
    private void sendNotification() {
        // Create a Notification object with the necessary data
        Notification notification = createNotification(
                "Flood",             // nature of disaster
                "Area 51",           // affected area
                "Severe",            // current status
                "Current Timestamp",  // timestamp
                "Evacuate immediately."  // instructions
        );

        // Pass the Notification object to sendNotification()
        viewModel.sendNotification(notification);
    }

    /**
     * Creates a Notification object with the specified parameters.
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
