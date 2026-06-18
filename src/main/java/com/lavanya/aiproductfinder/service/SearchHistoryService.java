package com.lavanya.aiproductfinder.service;

import com.lavanya.aiproductfinder.entity.SearchHistory;

import java.util.List;

public interface SearchHistoryService {

    void saveSearch(
            String email,
            String query
    );

    List<SearchHistory> getCurrentUserHistory(
            String email
    );

    void deleteHistory(
            String email,
            Long id
    );

    void clearHistory(
            String email
    );
}