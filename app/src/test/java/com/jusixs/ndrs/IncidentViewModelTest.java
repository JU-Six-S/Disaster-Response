package com.jusixs.ndrs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.jusixs.ndrs.ui.viewmodel.IncidentViewModel;
import com.jusixs.ndrs.data.repository.IncidentRepository;
import com.jusixs.ndrs.data.model.Incident;

public class IncidentViewModelTest {
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
    }

    @Test
    public void testFetchIncident() {
        Incident dummyIncident = new Incident("Flood", "Water", "Chicago", "2024-11-10T08:30", "200 sq ft");

        // Define behavior for the mock repository to return the dummy incident
        when(mockRepository.getIncident("Flood")).thenReturn(dummyIncident);

        // Fetch incident through ViewModel
        viewModel.fetchIncident("Flood");

        // Check if the LiveData in ViewModel holds the dummy incident data
        LiveData<Incident> liveData = viewModel.getIncidentLiveData();
        assertEquals(dummyIncident, liveData.getValue());
    }
}
