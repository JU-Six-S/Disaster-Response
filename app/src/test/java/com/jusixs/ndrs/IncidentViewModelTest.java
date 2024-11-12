package com.jusixs.ndrs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jusixs.ndrs.data.model.Incident;
import com.jusixs.ndrs.data.repository.IncidentRepository;
import com.jusixs.ndrs.ui.viewmodel.IncidentViewModel;

@RunWith(RobolectricTestRunner.class) // Use RobolectricTestRunner
@Config(sdk = {30})
public class IncidentViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private IncidentViewModel viewModel;
    private IncidentRepository mockRepository;



    @BeforeEach
    public void setUp() {
        mockRepository = Mockito.mock(IncidentRepository.class); // Create a mock repository
        viewModel = new IncidentViewModel(mockRepository); // Pass mock repository to ViewModel
    }

    @Test
    public void testReportIncident() {
        // Create dummy incident data
        Incident dummyIncident = new Incident("Flood", "Water", "Chicago", "2024-11-10T08:30", "200 sq ft");

        // Call the reportIncident method
        viewModel.reportIncident(dummyIncident);

        // Verify the repository's storeIncident method is called with the dummy data
        verify(mockRepository).storeIncident(dummyIncident);

        // Verify that incidentLiveData in ViewModel was set with dummyIncident
        //assertEquals(dummyIncident, viewModel.getIncidentLiveData().getValue());
    }

    @Test
    public void testReportIncident_validIncident() {
        // Create a valid dummy incident
        Incident dummyIncident = new Incident("Flood", "Water", "Chicago", "2024-11-10T08:30", "200 sq ft");

        // Call reportIncident with the valid incident
        viewModel.reportIncident(dummyIncident);

        // Verify storeIncident is called with the valid incident
        verify(mockRepository).storeIncident(dummyIncident);

        // Verify incidentLiveData is set with the correct incident
        //assertEquals(dummyIncident, viewModel.getIncidentLiveData().getValue());
    }

    @Test
    public void testReportIncident_nullIncident() {
        // Call reportIncident with a null value
        viewModel.reportIncident(null);

        // Verify storeIncident is not called if the incident is null
        verify(mockRepository, Mockito.never()).storeIncident(null);

        // Verify incidentLiveData is not updated for null incident
        //assertNull(viewModel.getIncidentLiveData().getValue());
    }

    @Test
    public void testReportIncident_emptyLocationIncident() {
        // Create an incident with an empty location
        Incident dummyIncident = new Incident("Flood", "Water", "", "2024-11-10T08:30", "200 sq ft");

        // Call reportIncident with the incident
        viewModel.reportIncident(dummyIncident);

        // Verify storeIncident is called with the empty location incident
        verify(mockRepository).storeIncident(dummyIncident);

        // Verify incidentLiveData is set with the correct incident
        //assertEquals(dummyIncident, viewModel.getIncidentLiveData().getValue());
    }


//    @Test
//    public void testFetchIncident() {
//        Incident dummyIncident = new Incident("Flood", "Water", "Chicago", "2024-11-10T08:30", "200 sq ft");
//
//        // Define behavior for the mock repository to return the dummy incident
//        when(mockRepository.getIncident("Flood")).thenReturn(dummyIncident);
//
//        // Fetch incident through ViewModel
//        viewModel.fetchIncident("Flood");
//
//        // Verify that incidentLiveData in ViewModel was set with dummyIncident
//        assertEquals(dummyIncident, viewModel.getIncidentLiveData().getValue());
//    }
}