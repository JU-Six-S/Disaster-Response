package com.jusixs.ndrs.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.jusixs.ndrs.model.NewsItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class responsible for managing and performing
 * CRUD operations on News items using Firebase Firestore.
 */
public class NewsRepository
{
    private final FirebaseFirestore db;
    private final MutableLiveData<String> statusMessage;
    private final MutableLiveData<List<NewsItem>> allNews;

    /**
     * Initializes the NewsRepository with Firestore instance
     * and LiveData objects to track news items and status messages.
     */
    public NewsRepository()
    {
        db = FirebaseFirestore.getInstance();
        statusMessage = new MutableLiveData<>();
        allNews = new MutableLiveData<>();
    }

    /**
     * Gets the status message LiveData to observe success or failure of operations.
     *
     * @return a LiveData object containing status messages.
     */
    public MutableLiveData<String> getStatusMessage()
    {
        return statusMessage;
    }

    /**
     * Retrieves all news items from Firestore and updates the allNews LiveData.
     *
     * @return a LiveData object containing a list of all news items.
     */
    public LiveData<List<NewsItem>> getAllNews()
    {
        CollectionReference newsCollection = db.collection("newsboard");

        newsCollection.get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        List<NewsItem> newsList = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            NewsItem newsItem = document.toObject(NewsItem.class);
                            newsList.add(newsItem);
                        }
                        allNews.setValue(newsList);
                    } else {
                        statusMessage.setValue("Failed to fetch news items");
                    }
                });
        return allNews;
    }

    /**
     * Adds a new news item to the Firestore collection.
     *
     * @param newsItem the NewsItem object to be added to Firestore.
     */
    public void addNews(NewsItem newsItem)
    {
        db.collection("newsboard").document(newsItem.getId()).set(newsItem)
                .addOnSuccessListener(aVoid -> statusMessage.setValue("News posted successfully"))
                .addOnFailureListener(e -> statusMessage.setValue("Failed to post news"));
    }

    /**
     * Updates an existing news item in the Firestore collection.
     *
     * @param newsItem the NewsItem object to be updated in Firestore.
     */
    public void updateNews(NewsItem newsItem)
    {
        db.collection("newsboard").document(newsItem.getId()).set(newsItem)
                .addOnSuccessListener(aVoid -> statusMessage.setValue("News updated successfully"))
                .addOnFailureListener(e -> statusMessage.setValue("Failed to update news"));
    }

    /**
     * Posts a red alert by setting the red alert status on a news item
     * and updating it in the Firestore collection.
     *
     * @param newsItem the NewsItem object to be marked with a red alert.
     */
    public void postRedAlert(NewsItem newsItem)
    {
        newsItem.setRedAlert(true);
        db.collection("newsboard").document(newsItem.getId()).set(newsItem)
                .addOnSuccessListener(aVoid -> statusMessage.setValue("Red Alert posted successfully"))
                .addOnFailureListener(e -> statusMessage.setValue("Failed to post red alert"));
    }

    /**
     * Deletes a news item from the Firestore collection.
     *
     * @param newsItemId the ID of the news item to be deleted.
     */
    public void deleteNews(String newsItemId)
    {
        db.collection("newsboard").document(newsItemId).delete()
                .addOnSuccessListener(aVoid -> statusMessage.setValue("News deleted successfully"))
                .addOnFailureListener(e -> statusMessage.setValue("Failed to delete news"));
    }
}
