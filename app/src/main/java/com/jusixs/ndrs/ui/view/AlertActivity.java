package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.ui.viewmodel.AlertViewModel;

public class AlertActivity extends AppCompatActivity {

    private AlertViewModel alertViewModel;
    private RadioGroup alertTypeGroup;
    private RadioGroup audienceGroup;
    private EditText messageInput;
    private Button sendAlertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        // Initialize UI components
        alertTypeGroup = findViewById(R.id.alertTypeGroup);
        audienceGroup = findViewById(R.id.audienceGroup);
        messageInput = findViewById(R.id.messageInput);
        sendAlertButton = findViewById(R.id.sendAlertButton);

        // Initialize ViewModel
        alertViewModel = new ViewModelProvider(this).get(AlertViewModel.class);

        // Observe alert status
        alertViewModel.getAlertStatus().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String status) {
                if ("sent".equals(status)) {
                    Toast.makeText(AlertActivity.this, "Alert sent successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AlertActivity.this, "Failed to send alert. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up send button click listener
        sendAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAlert();
            }
        });
    }

    private void sendAlert() {
        // Get selected alert type
        String alertType = ((RadioButton) findViewById(alertTypeGroup.getCheckedRadioButtonId())).getText().toString().toLowerCase();

        // Get selected audience
        String audience = ((RadioButton) findViewById(audienceGroup.getCheckedRadioButtonId())).getText().toString().toLowerCase();

        // Get message input
        String message = messageInput.getText().toString().trim();

        // Validate input
        if (message.isEmpty()) {
            Toast.makeText(this, "Please enter an alert message.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Send alert using ViewModel
        alertViewModel.sendAlert(alertType, message, audience, "normal", "Dhaka");
    }
}
