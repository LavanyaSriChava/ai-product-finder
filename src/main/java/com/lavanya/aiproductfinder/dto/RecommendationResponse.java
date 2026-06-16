package com.lavanya.aiproductfinder.dto;

import com.lavanya.aiproductfinder.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RecommendationResponse {

    private String aiSummary;

    private List<Product> recommendedProducts;
}