package com.jusixs.ndrs.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.model.NewsItem;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jusixs.ndrs.repository.NewsRepository;

public class NewsViewModel extends ViewModel {
    private final NewsRepository repository;
    private final MutableLiveData<NewsItem> selectedNews;
    private final LiveData<String> statusMessage;

    public NewsViewModel() {
        repository = new NewsRepository();
        selectedNews = new MutableLiveData<>();
        statusMessage = repository.getStatusMessage();
    }

    public LiveData<String> getStatusMessage() {
        return statusMessage;
    }

    public void addNews(String title, String description, String imageUrl, boolean isRedAlert) {
        String id = FirebaseFirestore.getInstance().collection("newsboard").document().getId();
        NewsItem newsItem = new NewsItem(id, title, description, imageUrl, isRedAlert);
        repository.addNews(newsItem);
    }

    public void updateNews(NewsItem newsItem) {
        repository.updateNews(newsItem);
    }

    public void postRedAlert(String title, String description, String imageUrl) {
        String id = FirebaseFirestore.getInstance().collection("newsboard").document().getId();
        NewsItem newsItem = new NewsItem(id, title, description, imageUrl, true);
        repository.postRedAlert(newsItem);
    }

    public void setSelectedNews(NewsItem newsItem) {
        selectedNews.setValue(newsItem);
    }

    public LiveData<NewsItem> getSelectedNews() {
        return selectedNews;
    }
}
