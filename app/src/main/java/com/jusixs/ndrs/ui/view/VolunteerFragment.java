package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.ui.viewmodel.VolunteerTaskViewModel;

public class VolunteerFragment extends Fragment {
    private VolunteerTaskViewModel viewModel;
    private EditText etName, etContact, etExpertise, etAvailability, etTask, etFeedback;
    private Button btnRegister, btnAllocate, btnSendEmail, btnSendSms, btnSendNotification, btnSubmitFeedback;
    private ViewFlipper viewFlipper;

    // Overriding onCreateView to inflate the fragment layout and initialize ViewModel
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);

        // Initializing the ViewModel
        viewModel = new ViewModelProvider(this).get(VolunteerTaskViewModel.class);

        // Initializing UI components
        initializeViews(view);
        // Setting button listeners
        setButtonListeners();

        return view;
    }

    // Method to initialize UI components
    private void initializeViews(View view) {
        etName = view.findViewById(R.id.et_name);
        etContact = view.findViewById(R.id.et_contact);
        etExpertise = view.findViewById(R.id.et_expertise);
        etAvailability = view.findViewById(R.id.et_availability);
        etTask = view.findViewById(R.id.et_task);
        etFeedback = view.findViewById(R.id.et_feedback);

        btnRegister = view.findViewById(R.id.btn_register);
        btnAllocate = view.findViewById(R.id.btn_allocate);
        btnSendEmail = view.findViewById(R.id.btn_send_email);
        btnSendSms = view.findViewById(R.id.btn_send_sms);
        btnSendNotification = view.findViewById(R.id.btn_send_notification);
        btnSubmitFeedback = view.findViewById(R.id.btn_submit_feedback);

        viewFlipper = view.findViewById(R.id.viewFlipper);
    }

    // Setting up button click listeners
    private void setButtonListeners() {
        btnRegister.setOnClickListener(v -> handleRegisterVolunteer());
        btnAllocate.setOnClickListener(v -> handleTaskAllocation());
        btnSendEmail.setOnClickListener(v -> handleCommunication("Email"));
        btnSendSms.setOnClickListener(v -> handleCommunication("SMS"));
        btnSendNotification.setOnClickListener(v -> handleCommunication("Notification"));
        btnSubmitFeedback.setOnClickListener(v -> handleFeedbackSubmission());
    }

    // Handles volunteer registration process
    private void handleRegisterVolunteer() {
        String name = etName.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String expertise = etExpertise.getText().toString().trim();
        String availability = etAvailability.getText().toString().trim();

        // Validation for empty fields
        if (name.isEmpty() || contact.isEmpty() || expertise.isEmpty() || availability.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calling ViewModel to register the volunteer
        boolean isRegistered = viewModel.registerVolunteer(name, contact, expertise, availability);
        if (isRegistered) {
            Toast.makeText(getContext(), "Volunteer Registered Successfully", Toast.LENGTH_SHORT).show();
            clearInputFields(); // Clear input fields after successful registration
        } else {
            Toast.makeText(getContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
        }
    }

    // Handles task allocation process
    private void handleTaskAllocation() {
        String taskDescription = etTask.getText().toString().trim();

        // Validation for empty task description
        if (taskDescription.isEmpty()) {
            Toast.makeText(getContext(), "Enter Task Description", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isTaskAllocated = viewModel.allocateTask(taskDescription);
        if (isTaskAllocated) {
            Toast.makeText(getContext(), "Task Allocated Successfully", Toast.LENGTH_SHORT).show();
            etTask.setText(""); // Clear task input field after allocation
        } else {
            Toast.makeText(getContext(), "Task Allocation Failed", Toast.LENGTH_SHORT).show();
        }
    }

    // Handles sending communication (Email, SMS, Notification)
    private void handleCommunication(String type) {
        boolean isSent = viewModel.sendCommunication(type);
        if (isSent) {
            Toast.makeText(getContext(), type + " Sent Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Failed to Send " + type, Toast.LENGTH_SHORT).show();
        }
    }

    // Handles feedback submission
    private void handleFeedbackSubmission() {
        String feedback = etFeedback.getText().toString().trim();

        // Validation for empty feedback
        if (feedback.isEmpty()) {
            Toast.makeText(getContext(), "Please enter feedback", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isFeedbackSubmitted = viewModel.submitFeedback(feedback);
        if (isFeedbackSubmitted) {
            Toast.makeText(getContext(), "Feedback Submitted Successfully", Toast.LENGTH_SHORT).show();
            etFeedback.setText(""); // Clear feedback input field after submission
        } else {
            Toast.makeText(getContext(), "Feedback Submission Failed", Toast.LENGTH_SHORT).show();
        }
    }

    // Clears the input fields after successful registration
    private void clearInputFields() {
        etName.setText("");
        etContact.setText("");
        etExpertise.setText("");
        etAvailability.setText("");
    }
}
