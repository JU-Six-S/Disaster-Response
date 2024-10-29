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


public class ArchiveFragment extends Fragment {

    private ArchiveViewModel archiveViewModel;
    private RecyclerView recyclerView;
    private ArchiveAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        archiveViewModel = new ViewModelProvider(this).get(ArchiveViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_archive, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        archiveViewModel.getArchiveData().observe(getViewLifecycleOwner(), this::updateUI);

        return root;
    }

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
