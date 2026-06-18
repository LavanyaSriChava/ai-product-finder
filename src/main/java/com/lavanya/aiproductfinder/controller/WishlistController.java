package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.dto.WishlistRequest;
import com.lavanya.aiproductfinder.entity.Wishlist;
import com.lavanya.aiproductfinder.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(
            WishlistService wishlistService) {

        this.wishlistService = wishlistService;
    }

    @PostMapping
    public ResponseEntity<Wishlist> saveWishlist(
            @RequestBody WishlistRequest request,
            Authentication authentication) {

        String email = authentication.getName();

        Wishlist wishlist =
                wishlistService.saveWishlist(
                        email,
                        request.getQuery(),
                        request.getRecommendation()
                );

        return ResponseEntity.ok(wishlist);
    }

    @GetMapping
    public ResponseEntity<List<Wishlist>>
    getCurrentUserWishlist(
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                wishlistService.getWishlist(email)
        );
    }

    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<String> removeWishlist(
            @PathVariable Long wishlistId) {

        wishlistService.removeWishlist(wishlistId);

        return ResponseEntity.ok(
                "Wishlist item removed successfully"
        );
    }
}