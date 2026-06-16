package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.dto.DashboardResponse;
import com.lavanya.aiproductfinder.repository.ProductRepository;
import com.lavanya.aiproductfinder.repository.SearchHistoryRepository;
import com.lavanya.aiproductfinder.repository.UserRepository;
import com.lavanya.aiproductfinder.repository.WishlistRepository;
import com.lavanya.aiproductfinder.service.AnalyticsService;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final WishlistRepository wishlistRepository;
    private final SearchHistoryRepository searchHistoryRepository;

    public AnalyticsServiceImpl(
            UserRepository userRepository,
            ProductRepository productRepository,
            WishlistRepository wishlistRepository,
            SearchHistoryRepository searchHistoryRepository) {

        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.wishlistRepository = wishlistRepository;
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Override
    public DashboardResponse getDashboardStats() {

        long totalUsers = userRepository.count();

        long totalProducts = productRepository.count();

        long totalWishlistItems = wishlistRepository.count();

        long totalSearches = searchHistoryRepository.count();

        return new DashboardResponse(
                totalUsers,
                totalProducts,
                totalWishlistItems,
                totalSearches
        );
    }
}