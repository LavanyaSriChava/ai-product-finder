package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.entity.Product;
import com.lavanya.aiproductfinder.entity.User;
import com.lavanya.aiproductfinder.entity.Wishlist;
import com.lavanya.aiproductfinder.exception.ProductNotFoundException;
import com.lavanya.aiproductfinder.exception.UserNotFoundException;
import com.lavanya.aiproductfinder.repository.ProductRepository;
import com.lavanya.aiproductfinder.repository.UserRepository;
import com.lavanya.aiproductfinder.repository.WishlistRepository;
import com.lavanya.aiproductfinder.service.WishlistService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WishlistServiceImpl(
            WishlistRepository wishlistRepository,
            UserRepository userRepository,
            ProductRepository productRepository) {

        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Wishlist addToWishlist(
            Long userId,
            Long productId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id: " + userId
                        ));

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id: " + productId
                        ));

        if (wishlistRepository
                .existsByUserIdAndProductId(userId, productId)) {

            throw new RuntimeException(
                    "Product already exists in wishlist"
            );
        }

        Wishlist wishlist = Wishlist.builder()
                .user(user)
                .product(product)
                .createdAt(LocalDateTime.now())
                .build();

        return wishlistRepository.save(wishlist);
    }

    @Override
    public List<Wishlist> getUserWishlist(Long userId) {

        return wishlistRepository.findByUserId(userId);
    }

    @Override
    public void removeFromWishlist(Long wishlistId) {

        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Wishlist item not found"
                        ));

        wishlistRepository.delete(wishlist);
    }
}