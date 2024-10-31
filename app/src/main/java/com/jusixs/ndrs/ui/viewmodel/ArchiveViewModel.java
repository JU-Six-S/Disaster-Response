package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.model.DisasterArchive;
import com.jusixs.ndrs.data.repository.ArchiveRepository;
import java.util.List;

/**
 * ViewModel class for managing and providing archived disaster data in the National Disaster Response System (NDRS) project.
 * This ViewModel handles data fetching from the {@link ArchiveRepository} and exposes it to the UI as LiveData.
 *
 * <p>The data is currently loaded from a dummy repository and can be observed by the UI to automatically update when the data changes.</p>
 *
 * <p>ViewModel lifecycle-aware, designed to survive configuration changes.</p>
 *
 * @see ArchiveRepository
 * @see DisasterArchive
 * @see LiveData
 * @see MutableLiveData
 *
 * Author: Sadman
 */
public class ArchiveViewModel extends ViewModel {

    private final MutableLiveData<List<DisasterArchive>> archiveData;
    private final ArchiveRepository repository;

    /**
     * Initializes the ViewModel by setting up the repository and loading initial data.
     */
    public ArchiveViewModel() {
        repository = new ArchiveRepository();
        archiveData = new MutableLiveData<>();
        loadArchivedData();
    }

    /**
     * Loads archived disaster data from the repository and updates the LiveData.
     */
    private void loadArchivedData() {
        // Get data from repository (dummy data in this case)
        archiveData.setValue(repository.getArchivedData());
    }

    /**
     * Returns LiveData containing the list of {@link DisasterArchive} objects.
     * Observers can use this data to get updates when the archived data changes.
     *
     * @return a LiveData instance containing a list of disaster archives
     */
    public LiveData<List<DisasterArchive>> getArchiveData() {
        return archiveData;
    }
}
