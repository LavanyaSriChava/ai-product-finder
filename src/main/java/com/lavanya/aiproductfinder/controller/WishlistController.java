package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.entity.Wishlist;
import com.lavanya.aiproductfinder.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping
    public ResponseEntity<Wishlist> addToWishlist(
            @RequestParam Long userId,
            @RequestParam Long productId) {

        Wishlist wishlist =
                wishlistService.addToWishlist(
                        userId,
                        productId
                );

        return ResponseEntity.ok(wishlist);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Wishlist>> getUserWishlist(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                wishlistService.getUserWishlist(userId)
        );
    }

    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<String> removeFromWishlist(
            @PathVariable Long wishlistId) {

        wishlistService.removeFromWishlist(wishlistId);

        return ResponseEntity.ok(
                "Product removed from wishlist successfully"
        );
    }
}