package com.lavanya.aiproductfinder.repository;

import com.lavanya.aiproductfinder.entity.SearchHistory;
import com.lavanya.aiproductfinder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository
        extends JpaRepository<SearchHistory, Long> {

    List<SearchHistory> findByUserOrderBySearchedAtDesc(
            User user
    );
    void deleteByIdAndUser(
            Long id,
            User user
    );

    void deleteByUser(
            User user
    );
}