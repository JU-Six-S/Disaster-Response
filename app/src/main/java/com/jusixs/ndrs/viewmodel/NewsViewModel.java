package com.jusixs.ndrs.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jusixs.ndrs.model.NewsItem;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jusixs.ndrs.repository.NewsRepository;

import java.util.List;

/**
 * ViewModel for managing news data and business logic.
 */
public class NewsViewModel extends ViewModel {
    private final NewsRepository repository;
    private final MutableLiveData<NewsItem> selectedNews;
    private final LiveData<String> statusMessage;
    private final LiveData<List<NewsItem>> allNews;
    private final FirebaseFirestore mockFirestore = null;

    /**
     * Constructor for NewsViewModel. Initializes the repository and LiveData objects.
     */
    public NewsViewModel( NewsRepository repository) {
        this.repository = repository;
        //repository = new NewsRepository(mockFirestore);
        selectedNews = new MutableLiveData<>();
        statusMessage = repository.getStatusMessage();
        allNews = repository.getAllNews();
    }

//    public NewsViewModel(NewsRepository mockRepository) {
//    }

    /**
     * Returns the LiveData object containing the status message.
     *
     * @return LiveData object containing the status message.
     */
    public LiveData<String> getStatusMessage() {
        return statusMessage;
    }

    /**
     * Adds a new news item to the repository.
     *
     * @param title       The title of the news item.
     * @param description The description of the news item.
     * @param imageUrl    The URL of the news item image.
     * @param isRedAlert  Indicates if the news item is a red alert.
     */
    public void addNews(String title, String description, String imageUrl, boolean isRedAlert) {
        String id = FirebaseFirestore.getInstance().collection("newsboard").document().getId();
        NewsItem newsItem = new NewsItem(id, title, description, imageUrl, isRedAlert);
        repository.addNews(newsItem);
    }

    /**
     * Updates the specified news item in the repository.
     *
     * @param newsItem The news item to be updated.
     */
    public void updateNews(NewsItem newsItem) {
        repository.updateNews(newsItem);
    }

    /**
     * Posts a red alert news item to the repository.
     *
     * @param title       The title of the red alert news item.
     * @param description The description of the red alert news item.
     * @param imageUrl    The URL of the red alert news item image.
     */
    public void postRedAlert(String title, String description, String imageUrl) {
        String id = FirebaseFirestore.getInstance().collection("newsboard").document().getId();
        NewsItem newsItem = new NewsItem(id, title, description, imageUrl, true);
        repository.postRedAlert(newsItem);
    }

    /**
     * Sets the currently selected news item.
     *
     * @param newsItem The news item to be selected.
     */
    public void setSelectedNews(NewsItem newsItem) {
        selectedNews.setValue(newsItem);
    }

    /**
     * Returns the LiveData object containing the currently selected news item.
     *
     * @return LiveData object containing the selected news item.
     */
    public LiveData<NewsItem> getSelectedNews() {
        return selectedNews;
    }

    /**
     * Returns the LiveData object containing all news items.
     *
     * @return LiveData object containing the list of all news items.
     */
    public LiveData<List<NewsItem>> getAllNews() {
        return allNews;
    }

    /**
     * Deletes the specified news item from the repository.
     *
     * @param newsItem The news item to be deleted.
     */
    public void deleteNews(NewsItem newsItem) {
        repository.deleteNews(newsItem.getId());
    }
}
