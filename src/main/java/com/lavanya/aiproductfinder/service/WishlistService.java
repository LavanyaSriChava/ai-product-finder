package com.lavanya.aiproductfinder.service;

import com.lavanya.aiproductfinder.entity.Wishlist;

import java.util.List;

public interface WishlistService {

    Wishlist saveWishlist(
            String email,
            String query,
            String recommendation
    );

    List<Wishlist> getWishlist(
            String email
    );

    void removeWishlist(
            Long wishlistId
    );
}