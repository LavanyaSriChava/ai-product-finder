package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.entity.SearchHistory;
import com.lavanya.aiproductfinder.service.SearchHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @GetMapping
    public ResponseEntity<List<SearchHistory>>
    getCurrentUserHistory(
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                searchHistoryService
                        .getCurrentUserHistory(email)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    deleteHistory(
            @PathVariable Long id,
            Authentication authentication) {

        searchHistoryService
                .deleteHistory(
                        authentication.getName(),
                        id
                );

        return ResponseEntity.ok(
                "History deleted"
        );
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String>
    clearHistory(
            Authentication authentication) {

        searchHistoryService
                .clearHistory(
                        authentication.getName()
                );

        return ResponseEntity.ok(
                "History cleared"
        );
    }
}