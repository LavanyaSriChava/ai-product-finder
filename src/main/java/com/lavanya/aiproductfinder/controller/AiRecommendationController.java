package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.dto.AiSearchRequest;
import com.lavanya.aiproductfinder.dto.AiSearchResponse;
import com.lavanya.aiproductfinder.dto.CompareRequest;
import com.lavanya.aiproductfinder.service.AiRecommendationService;
import com.lavanya.aiproductfinder.service.SearchHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiRecommendationController {

    private final AiRecommendationService aiRecommendationService;
    private final SearchHistoryService searchHistoryService;

    public AiRecommendationController(
            AiRecommendationService aiRecommendationService,
            SearchHistoryService searchHistoryService) {

        this.aiRecommendationService = aiRecommendationService;
        this.searchHistoryService = searchHistoryService;
    }
    @PostMapping("/compare")
    public ResponseEntity<AiSearchResponse>
    compareProducts(
            @RequestBody CompareRequest request) {

        String result =
                aiRecommendationService
                        .compareProducts(
                                request.getProduct1(),
                                request.getProduct2()
                        );

        return ResponseEntity.ok(
                new AiSearchResponse(result)
        );
    }
    @PostMapping("/search")
    public ResponseEntity<AiSearchResponse> searchProducts(
            @RequestBody AiSearchRequest request,
            Authentication authentication) {

        String email = authentication.getName();

        searchHistoryService.saveSearch(
                email,
                request.getQuery()
        );

        String recommendation =
                aiRecommendationService
                        .interpretUserQuery(
                                request.getQuery()
                        );

        return ResponseEntity.ok(
                new AiSearchResponse(recommendation)
        );
    }
}