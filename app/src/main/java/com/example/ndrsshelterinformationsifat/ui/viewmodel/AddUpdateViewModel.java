package com.example.ndrsshelterinformationsifat.ui.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ndrsshelterinformationsifat.data.model.ShelterItem;

public class AddUpdateViewModel extends AndroidViewModel {

    // MutableLiveData to hold the shelter item for testing purposes
    private final MutableLiveData<ShelterItem> savedItem = new MutableLiveData<>();

    public AddUpdateViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Saves the shelter item to internal state (LiveData for testing).
     * @param shelterItem the shelter item to be saved
     */
    public void saveItem(ShelterItem shelterItem) {
        // Simulate saving by setting the value in MutableLiveData
        savedItem.setValue(shelterItem);

        // Optionally, show a Toast message (this is for UI interaction, not necessary for tests)
        String message = "Item saved: "
                + shelterItem.getAddress() + ", "
                + shelterItem.getCapacity() + ", "
                + shelterItem.getContact() + ", "
                + shelterItem.getCategory();
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
    }

    // Get the LiveData for testing purposes
    public MutableLiveData<ShelterItem> getSavedItem() {
        return savedItem;
    }
}
