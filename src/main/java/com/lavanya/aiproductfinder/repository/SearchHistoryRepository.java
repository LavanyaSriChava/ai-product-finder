package com.lavanya.aiproductfinder.repository;

import com.lavanya.aiproductfinder.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository
        extends JpaRepository<SearchHistory, Long> {

    List<SearchHistory> findByUserId(Long userId);
}