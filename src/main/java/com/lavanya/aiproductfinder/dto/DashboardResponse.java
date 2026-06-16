package com.lavanya.aiproductfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DashboardResponse {

    private long totalUsers;

    private long totalProducts;

    private long totalWishlistItems;

    private long totalSearches;
}