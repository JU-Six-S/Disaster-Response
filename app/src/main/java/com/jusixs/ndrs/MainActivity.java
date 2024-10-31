package com.jusixs.ndrs;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jusixs.ndrs.R;
import com.jusixs.ndrs.model.NewsItem;
import com.jusixs.ndrs.viewmodel.NewsViewModel;

/**
 * Main activity for posting news items and handling user interactions.
 */
public class MainActivity extends AppCompatActivity {

    private NewsViewModel newsViewModel;
    private EditText titleEditText;
    private EditText descriptionEditText;
    private ImageView newsImageView;
    private Button uploadImageButton;
    private Button postNewsButton;
    private Button postRedAlertButton;
    private Uri imageUri; // URI to hold the selected image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        // Initialize UI components
        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        newsImageView = findViewById(R.id.newsImageView);
        uploadImageButton = findViewById(R.id.uploadImageButton);
        postNewsButton = findViewById(R.id.postNewsButton);
        postRedAlertButton = findViewById(R.id.postRedAlertButton);

        // Observe status messages
        newsViewModel.getStatusMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String status) {
                Toast.makeText(MainActivity.this, status, Toast.LENGTH_SHORT).show();
            }
        });

        // Set up button click listeners
        postNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String imageUrl = imageUri != null ? imageUri.toString() : ""; // Convert URI to String
                boolean isRedAlert = false;

                if (!title.isEmpty() && !description.isEmpty()) {
                    newsViewModel.addNews(title, description, imageUrl, isRedAlert);
                } else {
                    Toast.makeText(MainActivity.this, "Title and Description cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        postRedAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String imageUrl = imageUri != null ? imageUri.toString() : ""; // Convert URI to String

                if (!title.isEmpty() && !description.isEmpty()) {
                    newsViewModel.postRedAlert(title, description, imageUrl);
                } else {
                    Toast.makeText(MainActivity.this, "Title and Description cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle image upload
        ActivityResultLauncher<Intent> imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        imageUri = result.getData().getData();
                        newsImageView.setImageURI(imageUri); // Display the selected image
                    }
                });

        uploadImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            imagePickerLauncher.launch(intent);
        });
    }
}
