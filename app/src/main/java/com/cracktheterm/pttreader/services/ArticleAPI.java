package com.cracktheterm.pttreader.services;

import com.cracktheterm.pttreader.HotArticle;
import com.cracktheterm.pttreader.listeners.DataListener;

import java.util.List;

public interface ArticleAPI {
    public void fetchArticles(DataListener<List<HotArticle>> listener);
}
