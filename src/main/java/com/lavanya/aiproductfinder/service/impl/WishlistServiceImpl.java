package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.entity.User;
import com.lavanya.aiproductfinder.entity.Wishlist;
import com.lavanya.aiproductfinder.exception.UserNotFoundException;
import com.lavanya.aiproductfinder.repository.UserRepository;
import com.lavanya.aiproductfinder.repository.WishlistRepository;
import com.lavanya.aiproductfinder.service.WishlistService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WishlistServiceImpl
        implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    public WishlistServiceImpl(
            WishlistRepository wishlistRepository,
            UserRepository userRepository) {

        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Wishlist saveWishlist(
            String email,
            String query,
            String recommendation) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"
                        ));

        Wishlist wishlist =
                Wishlist.builder()
                        .user(user)
                        .query(query)
                        .recommendation(recommendation)
                        .createdAt(LocalDateTime.now())
                        .build();

        return wishlistRepository.save(wishlist);
    }
    @Override
    public void removeWishlist(
            Long wishlistId) {

        wishlistRepository.deleteById(
                wishlistId
        );
    }

    @Override
    public List<Wishlist> getWishlist(
            String email) {

        return wishlistRepository
                .findByUserEmail(email);
    }
}