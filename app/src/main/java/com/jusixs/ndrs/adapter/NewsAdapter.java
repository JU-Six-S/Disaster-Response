package com.jusixs.ndrs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jusixs.ndrs.NewsItemListener;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.model.NewsItem;

import java.util.List;

/**
 * Adapter for displaying a list of news items in a RecyclerView.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
{
    private final List<NewsItem> newsList;
    private final NewsItemListener listener;

    /**
     * Constructs a NewsAdapter with the specified news items and listener.
     *
     * @param newsList the list of news items to display
     * @param listener the listener for handling item click events
     */
    public NewsAdapter(List<NewsItem> newsList, NewsItemListener listener)
    {
        this.newsList = newsList;
        this.listener = listener;
    }

    /**
     * Inflates the item view for the RecyclerView.
     *
     * @param parent the parent ViewGroup
     * @param viewType the view type of the new View
     * @return a new instance of NewsViewHolder
     */
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    /**
     * Binds the data to the item view at the specified position.
     *
     * @param holder the NewsViewHolder to bind data to
     * @param position the position of the item in the list
     */
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position)
    {
        NewsItem newsItem = newsList.get(position);
        holder.titleTextView.setText(newsItem.getTitle());
        holder.descriptionTextView.setText(newsItem.getDescription());

        // Load image using Glide
        Glide.with(holder.itemView.getContext()).load(newsItem.getImageUrl()).into(holder.newsImageView);

        // Set click listener for edit
        holder.itemView.setOnClickListener(v -> listener.onEditNews(newsItem));

        // Set click listener for delete (long press)
        holder.itemView.setOnLongClickListener(v -> {
            listener.onDeleteNews(newsItem);
            return true;
        });
    }

    /**
     * Returns the total number of items in the news list.
     *
     * @return the size of the news list
     */
    @Override
    public int getItemCount()
    {
        return newsList.size();
    }

    /**
     * Updates the news list and refreshes the RecyclerView.
     *
     * @param newsItems the updated list of news items
     */
    public void updateNewsList(List<NewsItem> newsItems)
    {
        newsList.clear();
        newsList.addAll(newsItems);
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class for holding item views in the RecyclerView.
     */
    static class NewsViewHolder extends RecyclerView.ViewHolder
    {
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView newsImageView;

        /**
         * Constructs a NewsViewHolder and initializes its views.
         *
         * @param itemView the item view of the RecyclerView
         */
        public NewsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            newsImageView = itemView.findViewById(R.id.newsImageView);
        }
    }
}
