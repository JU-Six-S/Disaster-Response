package com.jusixs.ndrs.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jusixs.ndrs.NewsItemListener;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.adapter.NewsAdapter;
import com.jusixs.ndrs.model.NewsItem;
import com.jusixs.ndrs.viewmodel.NewsViewModel;

import java.util.ArrayList;

/**
 * Activity class to manage news items, allowing users to add, edit, delete, and post red alerts.
 */
public class ManageNewsActivity extends AppCompatActivity implements NewsItemListener
{
    private NewsViewModel newsViewModel;
    private EditText titleEditText, descriptionEditText;
    private ImageView newsImageView;
    private String imageUrl;
    private NewsAdapter newsAdapter;
    private NewsItem selectedNewsItem;

    /**
     * Initializes the activity, sets up UI elements, and observes ViewModel data.
     *
     * @param savedInstanceState the state of the activity saved during configuration changes.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        newsImageView = findViewById(R.id.newsImageView);

//        Button deleteNewsButton = findViewById(R.id.deleteNewsButton);
//        deleteNewsButton.setOnClickListener(this::confirmDeleteNews);

        Button uploadImageButton = findViewById(R.id.uploadImageButton);
        Button postNewsButton = findViewById(R.id.postNewsButton);
        Button postRedAlertButton = findViewById(R.id.postRedAlertButton);

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        // Observe status messages from ViewModel
        newsViewModel.getStatusMessage().observe(this, message -> {
            if (message != null) {
                Toast.makeText(ManageNewsActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        // Set up RecyclerView for displaying news items
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        newsAdapter = new NewsAdapter(new ArrayList<>(), new NewsItemListener() {
            @Override
            public void onEditNews(NewsItem newsItem) {
                editNews(newsItem);
            }

            @Override
            public void onDeleteNews(NewsItem newsItem) {
                deleteNews(newsItem);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newsAdapter);

        // Observe news list changes in ViewModel
        newsViewModel.getAllNews().observe(this, newsItems -> {
            newsAdapter.updateNewsList(newsItems);
        });

        // Set button click listeners
        uploadImageButton.setOnClickListener(this::uploadImage);
        postNewsButton.setOnClickListener(this::postNews);
        postRedAlertButton.setOnClickListener(this::postRedAlert);
    }

    /**
     * Invoked when an edit request is made for a news item.
     *
     * @param newsItem the news item to edit.
     */
    @Override
    public void onEditNews(NewsItem newsItem)
    {
        editNews(newsItem);
    }

    /**
     * Invoked when a delete request is made for a news item.
     *
     * @param newsItem the news item to delete.
     */
    @Override
    public void onDeleteNews(NewsItem newsItem)
    {
        deleteNews(newsItem);
    }

    /**
     * Confirms deletion of the currently selected news item.
     *
     * @param view the current view.
     */
    private void confirmDeleteNews(View view)
    {
        if (selectedNewsItem != null) {
            new AlertDialog.Builder(this)
                    .setTitle("Delete News")
                    .setMessage("Are you sure you want to delete this news item?")
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> deleteNews(selectedNewsItem))
                    .setNegativeButton(android.R.string.no, null)
                    .show();
        } else {
            Toast.makeText(this, "No news item selected for deletion", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Deletes the specified news item.
     *
     * @param newsItem the news item to delete.
     */
    private void deleteNews(NewsItem newsItem)
    {
        newsViewModel.deleteNews(newsItem);
        clearInputFields();
    }

    /**
     * Launches an intent to select an image from the gallery.
     *
     * @param view the current view.
     */
    private void uploadImage(View view)
    {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        imagePickerLauncher.launch(intent);
    }

    /**
     * Handles the result of the image picker intent.
     */
    private final ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    if (imageUri != null) {
                        imageUrl = imageUri.toString();
                        newsImageView.setImageURI(imageUri);
                    }
                }
            });

    /**
     * Posts or updates a news item based on the current input fields.
     *
     * @param view the current view.
     */
    private void postNews(View view)
    {
        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        if (!title.isEmpty() && !description.isEmpty() && imageUrl != null) {
            if (selectedNewsItem == null) {
                newsViewModel.addNews(title, description, imageUrl, false);
            } else {
                selectedNewsItem.setTitle(title);
                selectedNewsItem.setDescription(description);
                selectedNewsItem.setImageUrl(imageUrl);
                newsViewModel.updateNews(selectedNewsItem);
                selectedNewsItem = null; // Clear selection after update
            }
            clearInputFields();
        } else {
            Toast.makeText(this, "Please fill in all fields and upload an image", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Posts a red alert news item with the current input fields.
     *
     * @param view the current view.
     */
    private void postRedAlert(View view)
    {
        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        if (!title.isEmpty() && !description.isEmpty() && imageUrl != null) {
            newsViewModel.postRedAlert(title, description, imageUrl);
            clearInputFields();
        } else {
            Toast.makeText(this, "Please fill in all fields and upload an image", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Clears the input fields for title, description, and image preview.
     */
    private void clearInputFields()
    {
        titleEditText.setText("");
        descriptionEditText.setText("");
        newsImageView.setImageResource(0); // Clears the image preview
        imageUrl = null;
    }

    /**
     * Prepares the activity for editing the selected news item.
     *
     * @param newsItem the news item to be edited.
     */
    public void editNews(NewsItem newsItem)
    {
        selectedNewsItem = newsItem;
        titleEditText.setText(newsItem.getTitle());
        descriptionEditText.setText(newsItem.getDescription());
        imageUrl = newsItem.getImageUrl();
        newsImageView.setImageURI(Uri.parse(imageUrl));
    }

    /**
     * Selects a news item for editing by populating the edit fields with its data.
     *
     * @param newsItem the news item selected for editing.
     */
    public void onNewsItemSelected(NewsItem newsItem)
    {
        editNews(newsItem);
    }
}
