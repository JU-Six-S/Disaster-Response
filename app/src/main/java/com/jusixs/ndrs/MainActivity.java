package com.jusixs.ndrs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int IMAGE_PICK_REQUEST = 1;
    private ImageView imagePreview;
    private EditText editTextAffectedAreas, editTextUrgentMessage;
    private TextView textViewTimestamp, textViewPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        imagePreview = findViewById(R.id.imagePreview);
        editTextAffectedAreas = findViewById(R.id.editTextAffectedAreas);
        editTextUrgentMessage = findViewById(R.id.editTextUrgentMessage);
        textViewTimestamp = findViewById(R.id.textViewTimestamp);
        textViewPreview = findViewById(R.id.textViewPreview);
        Spinner spinnerDisaster = findViewById(R.id.spinnerDisaster);
        Spinner spinnerCurrentStatus = findViewById(R.id.spinnerCurrentStatus);
        Button buttonSelectImage = findViewById(R.id.buttonSelectImage);
        Button buttonPreviewNotification = findViewById(R.id.buttonPreviewNotification);

        // Media Channels Checkboxes and Spinners
        CheckBox checkBoxTV = findViewById(R.id.checkBoxTV);
        Spinner spinnerTV = findViewById(R.id.spinnerTV);
        CheckBox checkBoxRadio = findViewById(R.id.checkBoxRadio);
        Spinner spinnerRadio = findViewById(R.id.spinnerRadio);
        CheckBox checkBoxOnlineNews = findViewById(R.id.checkBoxOnlineNews);
        Spinner spinnerOnlineNews = findViewById(R.id.spinnerOnlineNews);
        CheckBox checkBoxSocialMedia = findViewById(R.id.checkBoxSocialMedia);
        Spinner spinnerSocialMedia = findViewById(R.id.spinnerSocialMedia);

        // Set current timestamp
        String currentTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        textViewTimestamp.setText(currentTimestamp);

        // Set up Adapters
        ArrayAdapter<CharSequence> adapterDisaster = ArrayAdapter.createFromResource(this,
                R.array.disaster_types, android.R.layout.simple_spinner_item);
        adapterDisaster.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisaster.setAdapter(adapterDisaster);

        ArrayAdapter<CharSequence> adapterStatus = ArrayAdapter.createFromResource(this,
                R.array.status_options, android.R.layout.simple_spinner_item);
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrentStatus.setAdapter(adapterStatus);

        ArrayAdapter<CharSequence> adapterChannels = ArrayAdapter.createFromResource(this,
                R.array.channel_options, android.R.layout.simple_spinner_item);
        adapterChannels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTV.setAdapter(adapterChannels);
        spinnerRadio.setAdapter(adapterChannels);
        spinnerOnlineNews.setAdapter(adapterChannels);
        spinnerSocialMedia.setAdapter(adapterChannels);

        // Handle checkbox visibility for spinners
        checkBoxTV.setOnCheckedChangeListener((buttonView, isChecked) -> spinnerTV.setVisibility(isChecked ? View.VISIBLE : View.GONE));
        checkBoxRadio.setOnCheckedChangeListener((buttonView, isChecked) -> spinnerRadio.setVisibility(isChecked ? View.VISIBLE : View.GONE));
        checkBoxOnlineNews.setOnCheckedChangeListener((buttonView, isChecked) -> spinnerOnlineNews.setVisibility(isChecked ? View.VISIBLE : View.GONE));
        checkBoxSocialMedia.setOnCheckedChangeListener((buttonView, isChecked) -> spinnerSocialMedia.setVisibility(isChecked ? View.VISIBLE : View.GONE));

        // Image selection
        buttonSelectImage.setOnClickListener(v -> selectImage());

        // Preview Notification
        buttonPreviewNotification.setOnClickListener(v -> previewNotification());

        // Save Draft and Send Notification actions
        findViewById(R.id.buttonSaveDraft).setOnClickListener(v -> saveDraft());
        findViewById(R.id.buttonSendNotification).setOnClickListener(v -> sendNotification());
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE_PICK_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICK_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            imagePreview.setImageURI(imageUri);
        }
    }

    private void previewNotification() {
        Spinner spinnerDisaster = findViewById(R.id.spinnerDisaster);
        Spinner spinnerCurrentStatus = findViewById(R.id.spinnerCurrentStatus);

        String disasterType = spinnerDisaster.getSelectedItem().toString();
        String affectedAreas = editTextAffectedAreas.getText().toString();
        String currentStatus = spinnerCurrentStatus.getSelectedItem().toString();
        String timestamp = textViewTimestamp.getText().toString();
        String urgentMessage = editTextUrgentMessage.getText().toString();

        String previewText = String.format("Nature of Disaster: %s\nAffected Areas: %s\nCurrent Status: %s\nTimestamp: %s\nUrgent Message: %s",
                disasterType, affectedAreas, currentStatus, timestamp, urgentMessage);

        textViewPreview.setText(previewText);
    }

    private void saveDraft() {
        // Logic to save draft (implement as needed)
        Toast.makeText(this, "Draft saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void sendNotification() {
        // Logic to send notification (implement as needed)
        Toast.makeText(this, "Notification sent successfully!", Toast.LENGTH_SHORT).show();
    }

}
