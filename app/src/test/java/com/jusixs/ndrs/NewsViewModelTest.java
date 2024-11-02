package com.jusixs.ndrs;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jusixs.ndrs.model.NewsItem;
import com.jusixs.ndrs.repository.NewsRepository;
import com.jusixs.ndrs.viewmodel.NewsViewModel;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class NewsViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private FirebaseFirestore mockFirestore;

    @Mock
    private NewsRepository mockRepository;

    private NewsViewModel newsViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // Pass the mock repository to the ViewModel
        newsViewModel = new NewsViewModel(mockRepository);
    }

    @Test
    public void testAddNews() {
        // Arrange
        String title = "Test News Title";
        String description = "Test Description";
        String imageUrl = "http://example.com/test-image.jpg";
        boolean isRedAlert = false;

        // Mock the behavior for addNews in the repository
        doNothing().when(mockRepository).addNews(any(NewsItem.class));

        // Act
        newsViewModel.addNews(title, description, imageUrl, isRedAlert);

        // Verify addNews was called
        verify(mockRepository, times(1)).addNews(any(NewsItem.class));
    }
}
