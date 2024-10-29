package com.jusixs.ndrs.repository;

import androidx.lifecycle.MutableLiveData;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.jusixs.ndrs.model.NewsItem;

public class NewsRepository {
    private final FirebaseFirestore db;
    private final MutableLiveData<String> statusMessage;

    public NewsRepository() {
        db = FirebaseFirestore.getInstance();
        statusMessage = new MutableLiveData<>();
    }

    public MutableLiveData<String> getStatusMessage() {
        return statusMessage;
    }

    public void addNews(NewsItem newsItem) {
        db.collection("newsboard").document(newsItem.getId()).set(newsItem)
                .addOnSuccessListener(aVoid -> {
                    statusMessage.setValue("News posted successfully");
                })
                .addOnFailureListener(e -> statusMessage.setValue("Failed to post news"));
    }

    public void updateNews(NewsItem newsItem) {
        db.collection("newsboard").document(newsItem.getId()).set(newsItem)
                .addOnSuccessListener(aVoid -> {
                    statusMessage.setValue("News updated successfully");
                })
                .addOnFailureListener(e -> statusMessage.setValue("Failed to update news"));
    }

    public void postRedAlert(NewsItem newsItem) {
        newsItem.setRedAlert(true);
        db.collection("newsboard").document(newsItem.getId()).set(newsItem)
                .addOnSuccessListener(aVoid -> {
                    statusMessage.setValue("Red Alert posted successfully");
                })
                .addOnFailureListener(e -> statusMessage.setValue("Failed to post red alert"));
    }
}
