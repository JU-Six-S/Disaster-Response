package com.jusixs.ndrs.ui.viewmodel;

import com.jusixs.ndrs.data.repository.DamageAssessmentRepository;
import com.jusixs.ndrs.data.model.Report;
import java.util.*;

public class DamageAssessmentViewModel {
    private DamageAssessmentRepository repository;
    private Map<String, String> assessments = new HashMap<>(); // Area name -> Severity level

    public DamageAssessmentViewModel(DamageAssessmentRepository repository) {
        this.repository = repository;
    }

    public boolean createAssessment(String location, String disasterType, String severity) {
        if (location == null || disasterType == null || severity == null) {
            return false; // Fails if any required field is missing
        }

        // Check for valid severity levels
        if (!severity.equals("Minor") && !severity.equals("Moderate") && !severity.equals("Severe")) {
            return false; // Fails if severity is invalid
        }

        // Additional logic can be added here, e.g., checking for duplicates
        return true;
    }

    // New method to collect data with offline support
    public boolean collectData(String locationData, String photoData) {
        if (repository.isOnline()) {
            return repository.uploadData(locationData, photoData);
        } else {
            return repository.storeDataLocally(locationData, photoData);
        }
    }

    // Method to categorize damage based on severity level
    public String categorizeDamage(int severityLevel) {
        if (severityLevel <= 2) return "Minor";
        if (severityLevel <= 4) return "Moderate";
        return "Severe";
    }

    // Method to add an assessment with a specific area and severity
    public void addAssessment(String area, String severity) {
        assessments.put(area, severity);
    }

    // Method to prioritize areas based on severity levels
    public List<String> prioritizeAreas() {
        List<Map.Entry<String, String>> entries = new ArrayList<>(assessments.entrySet());

        // Sort entries by severity level with "Severe" > "Moderate" > "Minor"
        entries.sort((e1, e2) -> {
            int severity1 = getSeverityValue(e1.getValue());
            int severity2 = getSeverityValue(e2.getValue());
            return Integer.compare(severity2, severity1); // Sort descending by severity
        });

        // Extract sorted area names into a list
        List<String> sortedAreas = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries) {
            sortedAreas.add(entry.getKey());
        }
        return sortedAreas;
    }

    // Helper method to map severity levels to numeric values for sorting
    private int getSeverityValue(String severity) {
        switch (severity) {
            case "Severe": return 3;
            case "Moderate": return 2;
            case "Minor": return 1;
            default: return 0;
        }
    }

    // New method to generate a report with provided details
    public Report generateReport(String location, String disasterType, String severity, String photoData) {
        return new Report(location, disasterType, severity, photoData);
    }

    // New method to submit a report based on online/offline status
    public boolean submitReport(Report report) {
        if (repository.isOnline()) {
            return repository.submitReport(report);
        } else {
            repository.storeReportLocally(report); // Store the report for future submission
            return false;
        }
    }
}
