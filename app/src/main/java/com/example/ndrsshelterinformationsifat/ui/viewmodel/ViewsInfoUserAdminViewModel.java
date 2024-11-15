package com.example.ndrsshelterinformationsifat.ui.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ndrsshelterinformationsifat.data.model.ShelterItem;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ViewModel for categorizing shelter items and managing their data.
 */
public class ViewsInfoUserAdminViewModel extends AndroidViewModel {

    public MutableLiveData<HashMap<String, List<ShelterItem>>> categoryItemsMap = new MutableLiveData<>();

    public ViewsInfoUserAdminViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Loads shelter items from an array of files, categorizes them, and posts the data to categoryItemsMap.
     * @param files array of files where each file name contains shelter details separated by underscores
     */
    public void loadItems(File[] files) {
        HashMap<String, List<ShelterItem>> itemsMap = new HashMap<>();

        for (File file : files) {
            String[] details = file.getName().split("_");
            if (details.length >= 4) {
                ShelterItem item = new ShelterItem(details[0], details[1], details[2], details[3]);
                itemsMap.computeIfAbsent(item.getCategory(), k -> new ArrayList<>()).add(item);
            }
        }
        categoryItemsMap.postValue(itemsMap);
    }
}
