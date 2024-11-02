package com.jusixs.ndrs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.jusixs.ndrs.data.model.Guideline;
import com.jusixs.ndrs.data.repository.GuidelineRepository;
import com.jusixs.ndrs.ui.viewmodel.GuidelineViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class GuidelineViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private GuidelineRepository repository;

    private GuidelineViewModel viewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new GuidelineViewModel(repository);
    }

    @Test
    public void testGetGuidelinesWithMatchingCriteria() {
        List<Guideline> guidelines = Arrays.asList(
                new Guideline("1", "Flood", "Dhaka", "High", "General Safety Measures", "2024-01-01"),
                new Guideline("2", "Cyclone", "Chattogram", "Moderate", "Evacuation Protocols", "2024-02-02")
        );

        MutableLiveData<List<Guideline>> liveData = new MutableLiveData<>(guidelines);
        when(repository.getGuidelines()).thenReturn(liveData);

        viewModel.getGuidelines("Flood", "Dhaka", "High").observeForever(result -> {
            assertNotNull(result);
            assertEquals(1, result.size());
            assertEquals("Flood", result.get(0).getType());
            assertEquals("Dhaka", result.get(0).getLocation());
            assertEquals("High", result.get(0).getSeverity());
        });
    }

    @Test
    public void testGetGuidelinesWithNoMatchingCriteria() {
        List<Guideline> guidelines = Arrays.asList(
                new Guideline("1", "Flood", "Dhaka", "High", "General Safety Measures", "2024-01-01"),
                new Guideline("2", "Cyclone", "Chattogram", "Moderate", "Evacuation Protocols", "2024-02-02")
        );

        MutableLiveData<List<Guideline>> liveData = new MutableLiveData<>(guidelines);
        when(repository.getGuidelines()).thenReturn(liveData);

        viewModel.getGuidelines("Earthquake", "Dhaka", "Low").observeForever(result -> {
            assertNotNull(result);
            assertEquals(0, result.size());
        });
    }
}
