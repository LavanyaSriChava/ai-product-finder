package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.dto.AiSearchRequest;
import com.lavanya.aiproductfinder.dto.AiSearchResponse;
import com.lavanya.aiproductfinder.service.AiRecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiRecommendationController {

    private final AiRecommendationService aiRecommendationService;

    public AiRecommendationController(
            AiRecommendationService aiRecommendationService) {

        this.aiRecommendationService = aiRecommendationService;
    }

    @PostMapping("/search")
    public ResponseEntity<AiSearchResponse> searchProducts(
            @RequestBody AiSearchRequest request) {

        String recommendation =
                aiRecommendationService.interpretUserQuery(
                        request.getQuery()
                );

        return ResponseEntity.ok(
                new AiSearchResponse(recommendation)
        );
    }
}