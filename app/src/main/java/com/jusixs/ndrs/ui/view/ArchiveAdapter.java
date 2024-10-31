package com.jusixs.ndrs.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.DisasterArchive;
import java.util.List;

/**
 * Adapter class for displaying archived disaster data in a RecyclerView within the National Disaster Response System (NDRS) project.
 * Binds {@link DisasterArchive} data to the view layout for each list item.
 *
 * <p>This adapter creates and binds each item view for a disaster archive entry, showing the title, date, and description.</p>
 *
 * @author Sadman
 */
public class ArchiveAdapter extends RecyclerView.Adapter<ArchiveAdapter.ArchiveViewHolder> {

    private List<DisasterArchive> archives;

    /**
     * Constructs a new {@code ArchiveAdapter} with a list of disaster archive entries.
     *
     * @param archives the list of {@link DisasterArchive} objects to be displayed in the RecyclerView
     */
    public ArchiveAdapter(List<DisasterArchive> archives) {
        this.archives = archives;
    }

    /**
     * Creates a new view holder for a disaster archive item.
     *
     * @param parent   the parent ViewGroup into which the new view will be added
     * @param viewType the type of the new view
     * @return a new {@link ArchiveViewHolder} holding the view for each disaster archive item
     */
    @Override
    public ArchiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_archive, parent, false);
        return new ArchiveViewHolder(view);
    }

    /**
     * Binds disaster archive data to the view holder for display in the list.
     *
     * @param holder   the view holder to bind data to
     * @param position the position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(ArchiveViewHolder holder, int position) {
        DisasterArchive archive = archives.get(position);
        holder.titleTextView.setText(archive.getTitle());
        holder.dateTextView.setText(archive.getDate());
        holder.descriptionTextView.setText(archive.getDescription());
    }

    /**
     * Returns the total number of disaster archive items to display.
     *
     * @return the total item count in the archives list
     */
    @Override
    public int getItemCount() {
        return archives.size();
    }

    /**
     * Sets a new list of disaster archive items for the adapter and refreshes the displayed data.
     *
     * @param archives the updated list of {@link DisasterArchive} objects
     */
    public void setArchives(List<DisasterArchive> archives) {
        this.archives = archives;
    }

    /**
     * ViewHolder class for displaying individual disaster archive items within the RecyclerView.
     * Holds references to the views displaying the title, date, and description of each disaster.
     */
    static class ArchiveViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, dateTextView, descriptionTextView;

        /**
         * Constructs a new {@code ArchiveViewHolder} and initializes view references.
         *
         * @param itemView the view representing an individual item in the RecyclerView
         */
        public ArchiveViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            dateTextView = itemView.findViewById(R.id.date);
            descriptionTextView = itemView.findViewById(R.id.description);
        }
    }
}
