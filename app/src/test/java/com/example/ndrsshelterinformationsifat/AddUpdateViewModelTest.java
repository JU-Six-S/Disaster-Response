package com.example.ndrsshelterinformationsifat.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;

import com.example.ndrsshelterinformationsifat.data.model.ShelterItem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddUpdateViewModelTest {

    private AddUpdateViewModel viewModel;

    @Before
    public void setUp() {
        // Initialize the ViewModel before each test
        Application application = ApplicationProvider.getApplicationContext();
        viewModel = new AddUpdateViewModel(application);
    }

    @Test
    public void testSaveItem() {
        // Given a new ShelterItem
        ShelterItem item = new ShelterItem("456 Maple Ave", "200", "555-5678", "Southside Civic Shelter");

        // Observer to check the LiveData
        Observer<ShelterItem> observer = new Observer<ShelterItem>() {
            @Override
            public void onChanged(ShelterItem shelterItem) {
                // Assert the values after saving
                assertNotNull(shelterItem); // Ensure that the shelter item is not null
                assertEquals("456 Maple Ave", shelterItem.getAddress());
                assertEquals("200", shelterItem.getCapacity());
                assertEquals("555-5678", shelterItem.getContact());
                assertEquals("Southside Civic Shelter", shelterItem.getCategory());
            }
        };

        // Observe the LiveData
        viewModel.getSavedItem().observeForever(observer);

        // When the item is saved
        viewModel.saveItem(item);

        // Verify that the LiveData was updated
        assertNotNull(viewModel.getSavedItem().getValue());
        assertEquals(item, viewModel.getSavedItem().getValue());

        // Cleanup
        viewModel.getSavedItem().removeObserver(observer);
    }
}
