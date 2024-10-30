package com.jusixs.ndrs.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.viewmodel.MainViewModel;

public class NotificationActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Observe the toast message
        viewModel.getToastMessage().observe(this, message -> {
            if (message != null) {
                Toast.makeText(NotificationActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        // Here, you can add other observers, like for notification data, or bind data to UI elements.
    }

    private void saveDraft() {
        // Example data for saving a draft
        viewModel.saveDraft("Flood", "Area 51", "Severe", "Current Timestamp", "Evacuate immediately.");
    }

    private void sendNotification() {
        viewModel.sendNotification();
    }
}
