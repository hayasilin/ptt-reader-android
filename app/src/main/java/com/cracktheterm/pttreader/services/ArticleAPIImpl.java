package com.cracktheterm.pttreader.services;

import com.cracktheterm.pttreader.HotArticle;
import com.cracktheterm.pttreader.listeners.DataListener;

import java.util.List;

public class ArticleAPIImpl implements ArticleAPI {
    @Override
    public void fetchArticles(final DataListener<List<HotArticle>> listener) {
        performRequest();
    }

    private void performRequest() {

    }
}
