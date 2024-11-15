package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.ui.viewmodel.VolunteerViewModel;

class VolunteerFragment extends Fragment {
    private VolunteerViewModel viewModel;
    private EditText etName, etContact, etExpertise, etAvailability, etTask, etFeedback;
    private Button btnRegister, btnAllocate, btnSendEmail, btnSendSms, btnSendNotification, btnSubmitFeedback;
    private ViewFlipper viewFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);
        viewModel = new ViewModelProvider(this).get(VolunteerViewModel.class);

        initializeViews(view);
        setButtonListeners();

        return view;
    }

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

    private void setButtonListeners() {
        btnRegister.setOnClickListener(v -> registerVolunteer());
        btnAllocate.setOnClickListener(v -> allocateTask());
        btnSendEmail.setOnClickListener(v -> sendCommunication("Email"));
        btnSendSms.setOnClickListener(v -> sendCommunication("SMS"));
        btnSendNotification.setOnClickListener(v -> sendCommunication("Notification"));
        btnSubmitFeedback.setOnClickListener(v -> submitFeedback());
    }

    private void registerVolunteer() {
        String name = etName.getText().toString();
        String contact = etContact.getText().toString();
        String expertise = etExpertise.getText().toString();
        String availability = etAvailability.getText().toString();

        if (!name.isEmpty() && !contact.isEmpty() && !expertise.isEmpty() && !availability.isEmpty()) {
            viewModel.registerVolunteer(name, contact, expertise, availability);
            Toast.makeText(getContext(), "Volunteer Registered Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void allocateTask() {
        String taskDescription = etTask.getText().toString();
        if (!taskDescription.isEmpty()) {
            Toast.makeText(getContext(), "Task Allocated: " + taskDescription, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Enter Task Description", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendCommunication(String type) {
        Toast.makeText(getContext(), "Sending " + type, Toast.LENGTH_SHORT).show();
    }

    private void submitFeedback() {
        String feedback = etFeedback.getText().toString();
        if (!feedback.isEmpty()) {
            Toast.makeText(getContext(), "Feedback Submitted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Please enter feedback", Toast.LENGTH_SHORT).show();
        }
    }
}
