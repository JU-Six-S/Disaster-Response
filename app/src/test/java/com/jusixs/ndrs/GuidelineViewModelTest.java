package com.jusixs.ndrs;

import static org.junit.Assert.*;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.jusixs.ndrs.data.model.Guideline;
import com.jusixs.ndrs.data.repository.GuidelineRepository;
import com.jusixs.ndrs.ui.viewmodel.GuidelineViewModel;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class GuidelineViewModelTest {

    private GuidelineViewModel viewModel;
    private GuidelineRepository mockRepository;

    @Before
    public void setUp() {
        // Mocking repository (if using a mock framework, e.g., Mockito)
        mockRepository = GuidelineRepository.getInstance();
        viewModel = new GuidelineViewModel();
    }

    @Test
    public void testGetGuidelinesByType() {
        // Arrange: Creating mock guidelines
        List<Guideline> mockGuidelines = new ArrayList<>();
        mockGuidelines.add(new Guideline("1", "Flood", "Dhaka", "High", "Sample guideline 1", "2024-01-01"));
        mockGuidelines.add(new Guideline("2", "Cyclone", "Khulna", "Moderate", "Sample guideline 2", "2024-01-02"));
        mockGuidelines.add(new Guideline("3", "Earthquake", "Sylhet", "Severe", "Sample guideline 3", "2024-01-03"));

        MutableLiveData<List<Guideline>> liveData = new MutableLiveData<>();
        liveData.setValue(mockGuidelines);

        // Act: Filter guidelines by type "Flood"
        viewModel.getGuidelines("Flood", "", "").observeForever(guidelines -> {
            assertEquals(1, guidelines.size());
            assertEquals("Flood", guidelines.get(0).getType());
        });
    }

    @Test
    public void testGetGuidelinesWithInvalidType() {
        // Act: Search for guidelines of non-existing type
        viewModel.getGuidelines("NonExistingType", "", "").observeForever(guidelines -> {
            assertEquals(0, guidelines.size());
        });
    }

    @Test
    public void testGetGuidelinesWithSeverity() {
        // Arrange & Act: Filter by severity level "High"
        viewModel.getGuidelines("", "", "High").observeForever(guidelines -> {
            assertNotNull(guidelines);
            assertFalse(guidelines.isEmpty());
            assertEquals("High", guidelines.get(0).getSeverity());
        });
    }
}
