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

/**
 * MainActivity class that handles the user interface for reporting incidents.
 * This activity allows the user to input incident details and report them using the ViewModel.
 */
public class MainActivity extends AppCompatActivity {
    private IncidentViewModel viewModel;

    /**
     * Initializes the activity, sets up the UI elements, and handles the reporting functionality.
     * Also observes changes in the incident data and updates the UI accordingly.
     *
     * @param savedInstanceState the saved instance state from the previous session (if any).
     */
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

        // Observe LiveData for updates to incident information
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

        // Handle the report button click
        btnReport.setOnClickListener(view -> {
            // Get input data from the UI fields
            String name = incidentName.getText().toString().trim();
            String type = incidentType.getText().toString().trim();
            String location = incidentLocation.getText().toString().trim();
            String time = incidentTime.getText().toString().trim();
            String area = incidentArea.getText().toString().trim();
            String assistance = assistanceType.getText().toString().trim();

            // Validate the input fields to ensure none are empty
            if (name.isEmpty() || type.isEmpty() || location.isEmpty() || time.isEmpty() || area.isEmpty() || assistance.isEmpty()) {
                tvResult.setText("Please fill all fields.");
                return;
            }

            // Create a new Incident object with the user-provided data
            Incident incident = new Incident(name, type, location, time, area, assistance);

            // Report the incident using the ViewModel
            viewModel.reportIncident(incident);

            // Check for redundancy: If an incident is already reported, show a message
            if (viewModel.isIncidentReported(name, location, time)) {
                tvResult.setText("This incident is already reported.");
            }
        });
    }
}
