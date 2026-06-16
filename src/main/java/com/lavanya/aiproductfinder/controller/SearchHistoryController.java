package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.entity.SearchHistory;
import com.lavanya.aiproductfinder.service.SearchHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search-history")
public class SearchHistoryController {

    private final SearchHistoryService searchHistoryService;

    public SearchHistoryController(
            SearchHistoryService searchHistoryService) {

        this.searchHistoryService = searchHistoryService;
    }

    @PostMapping
    public ResponseEntity<SearchHistory> saveSearch(
            @RequestParam Long userId,
            @RequestParam String query) {

        return ResponseEntity.ok(
                searchHistoryService.saveSearch(
                        userId,
                        query
                )
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SearchHistory>>
    getUserSearchHistory(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                searchHistoryService
                        .getUserSearchHistory(userId)
        );
    }
}