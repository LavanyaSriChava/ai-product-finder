package com.lavanya.aiproductfinder.service;

import com.lavanya.aiproductfinder.entity.SearchHistory;

import java.util.List;

public interface SearchHistoryService {

    SearchHistory saveSearch(
            Long userId,
            String query
    );

    List<SearchHistory> getUserSearchHistory(
            Long userId
    );
}