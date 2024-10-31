package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.DisasterArchive;
import com.jusixs.ndrs.ui.viewmodel.ArchiveViewModel;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment for displaying a list of archived disaster data in the National Disaster Response System (NDRS) project.
 * Fetches data from the {@link ArchiveViewModel} and displays it in a RecyclerView using {@link ArchiveAdapter}.
 *
 * <p>This fragment observes data changes and updates the UI accordingly.</p>
 *
 * <p>Layouts used: {@code fragment_archive.xml} for the overall layout, {@code item_archive.xml} for individual list items.</p>
 *
 * @author Sadman
 */
public class ArchiveFragment extends Fragment {

    private ArchiveViewModel archiveViewModel;
    private RecyclerView recyclerView;
    private ArchiveAdapter adapter;

    /**
     * Initializes the {@link ArchiveViewModel} for data handling.
     *
     * @param savedInstanceState the previously saved state of the fragment, if available
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        archiveViewModel = new ViewModelProvider(this).get(ArchiveViewModel.class);
    }

    /**
     * Inflates the layout for this fragment and sets up the RecyclerView to display archived disaster data.
     * Observes the data from {@link ArchiveViewModel} and updates the UI.
     *
     * @param inflater           the LayoutInflater used to inflate the fragment's view
     * @param container          the parent ViewGroup that the fragment's UI should be attached to
     * @param savedInstanceState the previously saved state of the fragment, if available
     * @return the root view of the inflated fragment layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_archive, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Observing data from the ViewModel and updating the UI
        archiveViewModel.getArchiveData().observe(getViewLifecycleOwner(), this::updateUI);

        return root;
    }

    /**
     * Updates the UI with a list of {@link DisasterArchive} data.
     * Sets up the adapter if not already set, or updates the existing adapter with new data.
     *
     * @param archives the list of disaster archives to display in the RecyclerView
     */
    private void updateUI(List<DisasterArchive> archives) {
        if (adapter == null) {
            adapter = new ArchiveAdapter(archives);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setArchives(archives);
            adapter.notifyDataSetChanged();
        }
    }
}
