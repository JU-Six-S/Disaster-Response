package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.Guideline;
import com.jusixs.ndrs.ui.viewmodel.GuidelineViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Activity to display guidelines based on search criteria.
 * Provides fields for type, location, and severity to filter guidelines.
 */
public class GetGuidelines extends AppCompatActivity {

    private GuidelineViewModel viewModel;
    private EditText searchType, searchLocation, searchSeverity;
    private Button searchButton;
    private RecyclerView guidelinesRecyclerView;
    private GuidelineAdapter guidelineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_guidelines);

        initViews();
        setupRecyclerView();
        loadDemoData();
        setupSearchButton();
        observeErrorMessages();
    }

    /**
     * Initializes view components.
     */
    private void initViews() {
        searchType = findViewById(R.id.searchType);
        searchLocation = findViewById(R.id.searchLocation);
        searchSeverity = findViewById(R.id.searchSeverity);
        searchButton = findViewById(R.id.searchButton);
        guidelinesRecyclerView = findViewById(R.id.guidelinesRecyclerView);
    }

    /**
     * Configures RecyclerView with adapter and layout manager.
     */
    private void setupRecyclerView() {
        guidelinesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        guidelineAdapter = new GuidelineAdapter();
        guidelinesRecyclerView.setAdapter(guidelineAdapter);
    }

    /**
     * Loads temporary demo data into the adapter to display initial guidelines.
     */
    private void loadDemoData() {
        List<Guideline> mockGuidelines = new ArrayList<>();
        mockGuidelines.add(new Guideline("1", "Flood", "Dhaka", "High", "Ensure all critical infrastructure is protected and prepare for immediate evacuation in low-lying areas.", "2024-01-01"));
        mockGuidelines.add(new Guideline("2", "Flood", "Chattogram", "Moderate", "Secure essential supplies and warn communities in flood-prone regions to stay updated with alerts.", "2024-01-02"));
        mockGuidelines.add(new Guideline("3", "Flood", "Sylhet", "High", "Set up temporary shelters in safe zones and assist in relocating vulnerable populations.", "2024-01-03"));
        mockGuidelines.add(new Guideline("4", "Flood", "Rangpur", "Severe", "Coordinate with local health services for emergency response and deploy rescue teams to affected zones.", "2024-01-04"));
        mockGuidelines.add(new Guideline("5", "Flood", "Barishal", "Moderate", "Distribute relief materials such as food, water, and medical supplies in anticipation of river overflow.", "2024-01-05"));
        mockGuidelines.add(new Guideline("6", "Cyclone", "Cox's Bazar", "Severe", "Evacuate coastal areas, reinforce shelters, and ensure emergency communication channels are operational.", "2024-02-10"));
        mockGuidelines.add(new Guideline("7", "Cyclone", "Khulna", "High", "Deploy early-warning systems, and provide guidance on securing homes and protecting livestock.", "2024-02-11"));
        mockGuidelines.add(new Guideline("8", "Cyclone", "Patuakhali", "Moderate", "Encourage residents to stock up on food, water, and medicine; keep updated with cyclone advisories.", "2024-02-12"));
        mockGuidelines.add(new Guideline("9", "Cyclone", "Barguna", "Severe", "Mobilize medical teams, reinforce evacuation protocols, and prepare for storm surge impact on vulnerable zones.", "2024-02-13"));

        // Earthquake guidelines
        mockGuidelines.add(new Guideline("10", "Earthquake", "Dhaka", "Severe", "Identify structurally unsafe buildings, conduct evacuation drills, and equip shelters with basic supplies.", "2024-03-01"));
        mockGuidelines.add(new Guideline("11", "Earthquake", "Sylhet", "High", "Prepare emergency response teams for immediate deployment and conduct public awareness campaigns.", "2024-03-02"));
        mockGuidelines.add(new Guideline("12", "Earthquake", "Chattogram", "Moderate", "Strengthen communication with local authorities to provide swift guidance on safe evacuation.", "2024-03-03"));

        // Landslide guidelines
        mockGuidelines.add(new Guideline("13", "Landslide", "Bandarban", "High", "Clear evacuation routes, set up temporary shelters, and monitor rainfall in vulnerable areas.", "2024-04-15"));
        mockGuidelines.add(new Guideline("14", "Landslide", "Chattogram Hill Tracts", "Moderate", "Advise residents in high-risk zones to relocate temporarily and avoid travel on steep paths.", "2024-04-16"));
        mockGuidelines.add(new Guideline("15", "Landslide", "Rangamati", "Severe", "Deploy teams for debris clearance and assess the structural safety of homes and roads.", "2024-04-17"));


        guidelineAdapter.setGuidelines(mockGuidelines);
    }


    /**
     * Sets up the search button to trigger guideline retrieval.
     */
    private void setupSearchButton() {
        viewModel = new ViewModelProvider(this).get(GuidelineViewModel.class);

        searchButton.setOnClickListener(v -> {
            String type = searchType.getText().toString();
            String location = searchLocation.getText().toString();
            String severity = searchSeverity.getText().toString();
            observeGuidelines(type, location, severity);
        });
    }

    /**
     * Observes the guidelines from the ViewModel based on search parameters.
     *
     * @param type The type of guideline to search.
     * @param location The location relevant to the guideline.
     * @param severity The severity level of the guideline.
     */
    private void observeGuidelines(String type, String location, String severity) {
        viewModel.getGuidelines(type, location, severity).observe(this, guidelines -> {
            if (guidelines != null) {
                guidelineAdapter.setGuidelines(guidelines);
            }
        });
    }

    /**
     * Observes and displays error messages from the ViewModel.
     */
    private void observeErrorMessages() {
        viewModel.getErrorMessage().observe(this, errorMessage -> {
            if (errorMessage != null) {
                Toast.makeText(GetGuidelines.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
