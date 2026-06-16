package com.lavanya.aiproductfinder.service;

import com.lavanya.aiproductfinder.entity.Wishlist;

import java.util.List;

public interface WishlistService {

    Wishlist addToWishlist(
            Long userId,
            Long productId
    );

    List<Wishlist> getUserWishlist(
            Long userId
    );

    void removeFromWishlist(
            Long wishlistId
    );
}