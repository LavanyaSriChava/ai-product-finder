package com.lavanya.aiproductfinder.service;

import com.lavanya.aiproductfinder.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByPriceRange(
            Double minPrice,
            Double maxPrice
    );

    List<Product> searchProducts(String keyword);

    void deleteProduct(Long id);
}