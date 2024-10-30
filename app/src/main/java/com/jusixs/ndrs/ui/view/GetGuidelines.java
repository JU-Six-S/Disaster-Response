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
