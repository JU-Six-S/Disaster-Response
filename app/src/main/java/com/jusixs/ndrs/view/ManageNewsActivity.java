package com.jusixs.ndrs.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.jusixs.ndrs.viewmodel.NewsViewModel;
import com.jusixs.ndrs.R;
import android.content.Intent;
import android.net.Uri;

public class ManageNewsActivity extends AppCompatActivity{
    private NewsViewModel newsViewModel;
    private EditText titleEditText, descriptionEditText;
    private ImageView newsImageView;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        newsImageView = findViewById(R.id.newsImageView);

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        newsViewModel.getStatusMessage().observe(this, message -> {
            if (message != null) {
                Toast.makeText(ManageNewsActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.uploadImageButton).setOnClickListener(this::uploadImage);
        findViewById(R.id.postNewsButton).setOnClickListener(this::postNews);
        findViewById(R.id.postRedAlertButton).setOnClickListener(this::postRedAlert);
    }

    private void uploadImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        imagePickerLauncher.launch(intent);
    }

    private final ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Uri imageUri = result.getData().getData();
                    imageUrl = imageUri.toString();
                    newsImageView.setImageURI(imageUri);
                }
            });

    private void postNews(View view) {
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        newsViewModel.addNews(title, description, imageUrl, false);
    }

    private void postRedAlert(View view) {
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        newsViewModel.postRedAlert(title, description, imageUrl);
    }
}
