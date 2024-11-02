package com.jusixs.ndrs.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.jusixs.ndrs.data.model.DisasterArchive;
import com.jusixs.ndrs.data.repository.ArchiveRepository;
import com.jusixs.ndrs.ui.viewmodel.ArchiveViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ArchiveViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    private ArchiveRepository mockRepository;

    private ArchiveViewModel viewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new ArchiveViewModel(mockRepository);
    }

    @Test
    public void getArchiveData_shouldReturnMockedData() {
        // Arrange: Create dummy data
        List<DisasterArchive> mockData = Arrays.asList(
                new DisasterArchive("Incident A", "2023-01-01", "Description A"),
                new DisasterArchive("Incident B", "2023-02-01", "Description B")
        );

        // Set up the mock repository to return the dummy data
        when(mockRepository.getArchivedData()).thenReturn(mockData);

        // Act: Call getArchiveData and verify data
        viewModel.getArchiveData().observeForever(archives -> {
            // Assert: Verify that the ViewModel provides the expected data
            assertEquals("Mock data should match", mockData, archives);
        });
    }
}
