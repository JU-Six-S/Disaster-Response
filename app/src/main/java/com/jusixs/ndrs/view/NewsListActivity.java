package com.jusixs.ndrs.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.adapter.NewsAdapter;
import com.jusixs.ndrs.NewsItemListener;
import com.jusixs.ndrs.model.NewsItem;
import com.jusixs.ndrs.viewmodel.NewsViewModel;

import java.util.ArrayList;

/**
 * Activity to display the list of news items.
 */
public class NewsListActivity extends AppCompatActivity {
    private NewsViewModel newsViewModel;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        // Initialize ViewModel
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newsAdapter);

        // Observe news items
        newsViewModel.getAllNews().observe(this, newsItems -> {
            newsAdapter.updateNewsList(newsItems);
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
