package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.ui.viewmodel.GuidelineViewModel;
import com.jusixs.ndrs.data.model.Guideline;

import java.util.List;

/**
 * Fragment for displaying guidelines related to different incidents.
 */
public class GetGuidelinesFragment extends Fragment {

    private GuidelineViewModel guidelineViewModel;
    private RecyclerView guidelineRecyclerView;
    private GuidelineAdapter guidelineAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        guidelineViewModel = new ViewModelProvider(this).get(GuidelineViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_guidelines, container, false);

        guidelineRecyclerView = view.findViewById(R.id.recyclerViewGuidelines);
        guidelineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        guidelineAdapter = new GuidelineAdapter();
        guidelineRecyclerView.setAdapter(guidelineAdapter);

        guidelineViewModel.getGuidelines().observe(getViewLifecycleOwner(), guidelines -> {
            guidelineAdapter.setGuidelines(guidelines);
        });

        return view;
    }
}
