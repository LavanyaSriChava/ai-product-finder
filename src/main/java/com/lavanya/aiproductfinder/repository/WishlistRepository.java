package com.lavanya.aiproductfinder.repository;

import com.lavanya.aiproductfinder.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository
        extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByUserId(Long userId);

    List<Wishlist> findByProductId(Long productId);

    boolean existsByUserIdAndProductId(
            Long userId,
            Long productId
    );
}