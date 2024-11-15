package com.jusixs.ndrs;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jusixs.ndrs.data.model.Incident;
import com.jusixs.ndrs.data.repository.IncidentRepository;
import com.jusixs.ndrs.ui.viewmodel.IncidentViewModel;

public class MainActivity extends AppCompatActivity {
    private IncidentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        IncidentRepository repository = new IncidentRepository(); // Replace with your actual repository implementation
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                .get(IncidentViewModel.class);

        // Initialize UI elements
        EditText incidentName = findViewById(R.id.incident_name);
        EditText incidentType = findViewById(R.id.incident_type);
        EditText incidentLocation = findViewById(R.id.incident_location);
        EditText incidentTime = findViewById(R.id.incident_time);
        EditText incidentArea = findViewById(R.id.incident_area);
        EditText assistanceType = findViewById(R.id.assistance_type);
        Button btnReport = findViewById(R.id.btn_report);
        TextView tvResult = findViewById(R.id.tv_result);

        // Observe LiveData
        viewModel.getIncidentLiveData().observe(this, new Observer<Incident>() {
            @Override
            public void onChanged(Incident incident) {
                if (incident != null) {
                    tvResult.setText("Incident Reported Successfully:\n" +
                            "Name: " + incident.getName() + "\n" +
                            "Type: " + incident.getType() + "\n" +
                            "Location: " + incident.getLocation() + "\n" +
                            "Time: " + incident.getTime() + "\n" +
                            "Affected Area: " + incident.getAffectedArea() + "\n" +
                            "Assistance Type: " + incident.getAssistanceType());
                }
            }
        });

        // Handle button click
        btnReport.setOnClickListener(view -> {
            String name = incidentName.getText().toString().trim();
            String type = incidentType.getText().toString().trim();
            String location = incidentLocation.getText().toString().trim();
            String time = incidentTime.getText().toString().trim();
            String area = incidentArea.getText().toString().trim();
            String assistance = assistanceType.getText().toString().trim();

            // Validate input
            if (name.isEmpty() || type.isEmpty() || location.isEmpty() || time.isEmpty() || area.isEmpty() || assistance.isEmpty()) {
                tvResult.setText("Please fill all fields.");
                return;
            }

            // Create a new Incident object
            Incident incident = new Incident(name, type, location, time, area, assistance);

            // Report incident
            viewModel.reportIncident(incident);

            // Check for redundancy
            if (viewModel.isIncidentReported(name, location, time)) {
                tvResult.setText("This incident is already reported.");
            }
        });
    }
}


