package com.jusixs.ndrs;

import com.jusixs.ndrs.model.NewsItem;

/**
 * Interface for listening to news item events such as edit and delete actions.
 */
public interface NewsItemListener {

    /**
     * Called when a news item needs to be edited.
     *
     * @param newsItem The news item to be edited.
     */
    void onEditNews(NewsItem newsItem);

    /**
     * Called when a news item needs to be deleted.
     *
     * @param newsItem The news item to be deleted.
     */
    void onDeleteNews(NewsItem newsItem);
}
