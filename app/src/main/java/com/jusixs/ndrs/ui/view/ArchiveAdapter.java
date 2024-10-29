package com.jusixs.ndrs.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.DisasterArchive;
import java.util.List;

public class ArchiveAdapter extends RecyclerView.Adapter<ArchiveAdapter.ArchiveViewHolder> {

    private List<DisasterArchive> archives;

    public ArchiveAdapter(List<DisasterArchive> archives) {
        this.archives = archives;
    }

    @Override
    public ArchiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_archive, parent, false);
        return new ArchiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArchiveViewHolder holder, int position) {
        DisasterArchive archive = archives.get(position);
        holder.titleTextView.setText(archive.getTitle());
        holder.dateTextView.setText(archive.getDate());
        holder.descriptionTextView.setText(archive.getDescription());
    }

    @Override
    public int getItemCount() {
        return archives.size();
    }

    public void setArchives(List<DisasterArchive> archives) {
        this.archives = archives;
    }

    static class ArchiveViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, dateTextView, descriptionTextView;

        public ArchiveViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            dateTextView = itemView.findViewById(R.id.date);
            descriptionTextView = itemView.findViewById(R.id.description);
        }
    }
}

