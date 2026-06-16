package com.lavanya.aiproductfinder.dto;

public class AiSearchResponse {

    private String recommendation;

    public AiSearchResponse() {
    }

    public AiSearchResponse(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}