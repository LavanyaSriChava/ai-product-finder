package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.entity.SearchHistory;
import com.lavanya.aiproductfinder.entity.User;
import com.lavanya.aiproductfinder.exception.UserNotFoundException;
import com.lavanya.aiproductfinder.repository.SearchHistoryRepository;
import com.lavanya.aiproductfinder.repository.UserRepository;
import com.lavanya.aiproductfinder.service.SearchHistoryService;
import jakarta.transaction.Transactional;
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
    public void saveSearch(
            String email,
            String query) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"
                        ));

        SearchHistory searchHistory =
                SearchHistory.builder()
                        .user(user)
                        .query(query)
                        .searchedAt(LocalDateTime.now())
                        .build();

        searchHistoryRepository.save(searchHistory);
    }@Override
    @Transactional
    public void deleteHistory(
            String email,
            Long id) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"
                        ));

        SearchHistory history =
                searchHistoryRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "History not found"
                                ));

        if (!history.getUser()
                .getId()
                .equals(user.getId())) {

            throw new RuntimeException(
                    "Unauthorized"
            );
        }

        searchHistoryRepository
                .delete(history);
    }

    @Override
    public void clearHistory(
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"
                        ));

        searchHistoryRepository
                .deleteByUser(user);
    }

    @Override
    public List<SearchHistory> getCurrentUserHistory(
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"
                        ));

        return searchHistoryRepository
                .findByUserOrderBySearchedAtDesc(user);
    }
}