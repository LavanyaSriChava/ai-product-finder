package com.lavanya.aiproductfinder.service;

public interface AiRecommendationService {

    String interpretUserQuery(String query);
    String compareProducts(
            String product1,
            String product2
    );
}