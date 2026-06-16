package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.entity.SearchHistory;
import com.lavanya.aiproductfinder.entity.User;
import com.lavanya.aiproductfinder.exception.UserNotFoundException;
import com.lavanya.aiproductfinder.repository.SearchHistoryRepository;
import com.lavanya.aiproductfinder.repository.UserRepository;
import com.lavanya.aiproductfinder.service.SearchHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchHistoryServiceImpl
        implements SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;
    private final UserRepository userRepository;

    public SearchHistoryServiceImpl(
            SearchHistoryRepository searchHistoryRepository,
            UserRepository userRepository) {

        this.searchHistoryRepository = searchHistoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SearchHistory saveSearch(
            Long userId,
            String query) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id: " + userId
                        ));

        SearchHistory searchHistory =
                SearchHistory.builder()
                        .user(user)
                        .query(query)
                        .searchedAt(LocalDateTime.now())
                        .build();

        return searchHistoryRepository.save(searchHistory);
    }

    @Override
    public List<SearchHistory> getUserSearchHistory(
            Long userId) {

        return searchHistoryRepository.findByUserId(userId);
    }
}