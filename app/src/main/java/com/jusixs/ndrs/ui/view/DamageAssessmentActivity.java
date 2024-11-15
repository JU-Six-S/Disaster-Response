package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.Report;
import com.jusixs.ndrs.data.repository.DamageAssessmentRepository;
import com.jusixs.ndrs.ui.viewmodel.DamageAssessmentViewModel;

public class DamageAssessmentActivity extends AppCompatActivity {

    // UI components
    private Button buttonGenerateReport;
    private Button buttonSubmitReport;
    private TextView textViewReportDetails;
    private EditText inputLocation, inputDisasterType, inputSeverity;
    private ImageButton buttonSelectImage;

    // ViewModel and Report objects
    private DamageAssessmentViewModel viewModel;
    private Report report;
    private String photoData = ""; // Placeholder for photo data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage_assessment);

        // Initialize UI components and ViewModel
        initializeUI();
        viewModel = new DamageAssessmentViewModel(new DamageAssessmentRepository());

        // Set up button click listeners
        setupGenerateReportButton();
        setupSubmitReportButton();
    }

    // Initialize UI components
    private void initializeUI() {
        buttonGenerateReport = findViewById(R.id.buttonGenerateReport);
        buttonSubmitReport = findViewById(R.id.buttonSubmitReport);
        textViewReportDetails = findViewById(R.id.textViewReportDetails);
        inputLocation = findViewById(R.id.inputLocation);
        inputDisasterType = findViewById(R.id.inputDisasterType);
        inputSeverity = findViewById(R.id.inputSeverity);
        buttonSelectImage = findViewById(R.id.buttonSelectImage);

        buttonSelectImage.setOnClickListener(v -> {
            // Logic to select an image and set `photoData`
            // Placeholder code for image selection, this can be enhanced with actual image picker logic
            photoData = "selected_image_data"; // Example data
        });
    }

    // Set up Generate Report button click listener
    private void setupGenerateReportButton() {
        buttonGenerateReport.setOnClickListener(v -> {
            String location = inputLocation.getText().toString().trim();
            String disasterType = inputDisasterType.getText().toString().trim();
            String severity = inputSeverity.getText().toString().trim();

            // Validate inputs
            if (location.isEmpty() || disasterType.isEmpty() || severity.isEmpty()) {
                showToast("Please fill all fields.");
                return;
            }

            // Generate the report and display details
            report = viewModel.generateReport(location, disasterType, severity, photoData);
            displayReport(report);
        });
    }

    // Display report details in the TextView
    private void displayReport(Report report) {
        if (report != null) {
            String reportDetails = "Location: " + report.getLocation() +
                    "\nDisaster Type: " + report.getDisasterType() +
                    "\nSeverity: " + report.getSeverity() +
                    "\nPhoto Data: " + report.getPhotoData();
            textViewReportDetails.setText(reportDetails);
        } else {
            textViewReportDetails.setText("Failed to generate report.");
        }
    }

    // Set up Submit Report button click listener
    private void setupSubmitReportButton() {
        buttonSubmitReport.setOnClickListener(v -> {
            if (report != null) {
                // Submit report and show feedback
                boolean success = viewModel.submitReport(report);
                if (success) {
                    showToast("Report submitted successfully");
                } else {
                    showToast("Submission failed. Will retry when online.");
                }
            } else {
                showToast("No report to submit. Generate a report first.");
            }
        });
    }

    // Display a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
