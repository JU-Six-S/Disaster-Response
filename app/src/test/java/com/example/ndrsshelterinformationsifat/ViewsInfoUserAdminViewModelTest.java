package com.example.ndrsshelterinformationsifat;

import android.app.Application;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;

import com.example.ndrsshelterinformationsifat.data.model.ShelterItem;
import com.example.ndrsshelterinformationsifat.ui.viewmodel.ViewsInfoUserAdminViewModel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class ViewsInfoUserAdminViewModelTest {

    private ViewsInfoUserAdminViewModel viewModel;

    @Before
    public void setUp() {
        Application application = ApplicationProvider.getApplicationContext();
        viewModel = new ViewsInfoUserAdminViewModel(application);
    }

    @Test
    public void testLoadItems() {
        // Create mock ShelterItem files
        File file1 = new File("file1", "123_Main_50_555-1234_CityHallShelter");
        File file2 = new File("file2", "456_Maple_100_555-5678_SouthsideCivicShelter");
        File[] files = {file1, file2};

        // Set up observer for the LiveData
        final HashMap<String, List<ShelterItem>>[] categoryItemsMapHolder = new HashMap[1];
        Observer<HashMap<String, List<ShelterItem>>> observer = new Observer<HashMap<String, List<ShelterItem>>>() {
            @Override
            public void onChanged(HashMap<String, List<ShelterItem>> categoryItemsMap) {
                // Capture the LiveData value when it changes
                categoryItemsMapHolder[0] = categoryItemsMap;
            }
        };

        // Observe LiveData
        viewModel.categoryItemsMap.observeForever(observer);

        // Call the method under test
        viewModel.loadItems(files);

        // Wait for LiveData to be updated (if necessary, you can add a delay or use a more advanced approach)
        // Then check the result
        assertNotNull(categoryItemsMapHolder[0]);
        assertEquals(2, categoryItemsMapHolder[0].size());
        assertNotNull(categoryItemsMapHolder[0].get("CityHallShelter"));
        assertEquals(1, categoryItemsMapHolder[0].get("CityHallShelter").size());
        assertNotNull(categoryItemsMapHolder[0].get("SouthsideCivicShelter"));
        assertEquals(1, categoryItemsMapHolder[0].get("SouthsideCivicShelter").size());

        // Cleanup observer after the test
        viewModel.categoryItemsMap.removeObserver(observer);
    }
}
