package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.model.DisasterArchive;
import com.jusixs.ndrs.data.repository.ArchiveRepository;
import java.util.List;

public class ArchiveViewModel extends ViewModel {
    private final MutableLiveData<List<DisasterArchive>> archiveData;
    private final ArchiveRepository repository;

    public ArchiveViewModel() {
        repository = new ArchiveRepository();
        archiveData = new MutableLiveData<>();
        loadArchivedData();
    }

    private void loadArchivedData() {
        // Get data from repository (dummy data in this case)
        archiveData.setValue(repository.getArchivedData());
    }

    public LiveData<List<DisasterArchive>> getArchiveData() {
        return archiveData;
    }
}