package com.jusixs.ndrs.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.adapter.NewsAdapter;
import com.jusixs.ndrs.NewsItemListener;
import com.jusixs.ndrs.model.NewsItem;
import com.jusixs.ndrs.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity to display the list of news items.
 */
public class NewsListActivity extends AppCompatActivity {
    private NewsViewModel newsViewModel;
    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        // Initialize ViewModel
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        // Set up RecyclerView
        newsRecyclerView = findViewById(R.id.recyclerView);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter with a listener
        newsAdapter = new NewsAdapter(new ArrayList<>(), new NewsItemListener() {
            @Override
            public void onEditNews(NewsItem newsItem) {
                editNews(newsItem); // Implement edit logic
            }

            @Override
            public void onDeleteNews(NewsItem newsItem) {
                deleteNews(newsItem); // Implement delete logic
            }
        });

        newsRecyclerView.setAdapter(newsAdapter);

        // Observe the LiveData for all news items
        newsViewModel.getAllNews().observe(this, new Observer<List<NewsItem>>() {
            @Override
            public void onChanged(List<NewsItem> newsItems) {
                // Update the adapter when data changes
                newsAdapter.setNewsItems(newsItems); // Ensure you have a method to set items
            }
        });
    }

    /**
     * Starts the ManageNewsActivity to edit the selected news item.
     *
     * @param newsItem The news item to be edited.
     */
    private void editNews(NewsItem newsItem) {
        Intent intent = new Intent(this, ManageNewsActivity.class);
        // Assuming you have a method to serialize NewsItem, e.g., using Parcelable
        intent.putExtra("selectedNewsItem", newsItem);
        startActivity(intent);
    }

    /**
     * Deletes the specified news item and shows a toast message.
     *
     * @param newsItem The news item to be deleted.
     */
    private void deleteNews(NewsItem newsItem) {
        // Call the ViewModel to delete the news item
        newsViewModel.deleteNews(newsItem);
        Toast.makeText(this, "News item deleted", Toast.LENGTH_SHORT).show();
    }
}
