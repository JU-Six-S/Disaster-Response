package com.jusixs.ndrs;

import com.jusixs.ndrs.ui.viewmodel.DamageAssessmentViewModel;
import com.jusixs.ndrs.data.repository.DamageAssessmentRepository;
import com.jusixs.ndrs.data.model.Report; // Import Report class
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class DamageAssessmentViewModelTest {

    // MockRepository as a nested class to simulate online/offline behavior
    class MockRepository extends DamageAssessmentRepository {
        private boolean isOnline;

        public MockRepository(boolean isOnline) {
            this.isOnline = isOnline;
        }

        @Override
        public boolean isOnline() {
            return isOnline;
        }

        @Override
        public boolean uploadData(String locationData, String photoData) {
            return isOnline; // Returns true only if online
        }

        @Override
        public boolean storeDataLocally(String locationData, String photoData) {
            return !isOnline; // Returns true only if offline
        }
    }

    // Test for creating a new assessment
    @Test
    public void createNewAssessment_successful() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        boolean result = viewModel.createAssessment("LocationA", "Flood", "Moderate");
        assertTrue(result);
    }

    @Test
    public void createNewAssessment_missingLocation_fails() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        boolean result = viewModel.createAssessment(null, "Flood", "Moderate");
        assertFalse(result);
    }

    @Test
    public void createNewAssessment_missingDisasterType_fails() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        boolean result = viewModel.createAssessment("LocationA", null, "Moderate");
        assertFalse(result);
    }

    @Test
    public void createNewAssessment_missingSeverity_fails() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        boolean result = viewModel.createAssessment("LocationA", "Flood", null);
        assertFalse(result);
    }

    @Test
    public void createNewAssessment_invalidSeverity_fails() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        boolean result = viewModel.createAssessment("LocationA", "Flood", "Extreme"); // Assuming only Minor, Moderate, Severe are valid
        assertFalse(result);
    }

    @Test
    public void collectData_online_successfulUpload() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true)); // true = online
        boolean result = viewModel.collectData("location_data", "photo_data");
        assertTrue(result); // Should succeed as we're simulating an online state
    }

    @Test
    public void collectData_offline_storesLocally() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(false)); // false = offline
        boolean result = viewModel.collectData("location_data", "photo_data");
        assertTrue(result); // Should succeed locally even when offline
    }

    // Test for categorizing damage level based on severity
    @Test
    public void categorizeDamage_moderateCategoryAssigned() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        String category = viewModel.categorizeDamage(3); // Assume '3' maps to Moderate
        assertEquals("Moderate", category);
    }

    // Test for prioritizing areas based on severity, most affected should come first
    @Test
    public void prioritizeAreas_mostAffectedFirst() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        viewModel.addAssessment("Area1", "Severe");  // Severe impact
        viewModel.addAssessment("Area2", "Moderate"); // Moderate impact
        List<String> prioritized = viewModel.prioritizeAreas();
        assertEquals("Area1", prioritized.get(0)); // "Area1" should be prioritized as it is more affected
    }

    // Test for successful report generation
    @Test
    public void generateReport_successfullyCreated() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true));
        Report report = viewModel.generateReport("LocationA", "Flood", "Severe", "photo_data");
        assertNotNull(report);
        assertEquals("LocationA", report.getLocation());
        assertEquals("Flood", report.getDisasterType());
        assertEquals("Severe", report.getSeverity());
        assertEquals("photo_data", report.getPhotoData());
    }

    // Test for successful report submission when online
    @Test
    public void submitReport_successfullySubmitted() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(true)); // online state
        boolean result = viewModel.submitReport(new Report("LocationA", "Flood", "Severe", "photo_data"));
        assertTrue(result); // Should succeed as we're simulating an online state
    }

    // Test for failed report submission when offline
    @Test
    public void submitReport_submissionFails() {
        DamageAssessmentViewModel viewModel = new DamageAssessmentViewModel(new MockRepository(false)); // offline state
        boolean result = viewModel.submitReport(new Report("LocationA", "Flood", "Severe", "photo_data"));
        assertFalse(result); // Should fail as we're simulating an offline state
    }
}
