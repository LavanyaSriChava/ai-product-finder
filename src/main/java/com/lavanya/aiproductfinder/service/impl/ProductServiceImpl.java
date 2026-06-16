package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.entity.Product;
import com.lavanya.aiproductfinder.exception.ProductNotFoundException;
import com.lavanya.aiproductfinder.repository.ProductRepository;
import com.lavanya.aiproductfinder.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {

        product.setCreatedAt(LocalDateTime.now());

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id: " + id
                        ));
    }

    @Override
    public List<Product> getProductsByCategory(String category) {

        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {

        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByPriceRange(
            Double minPrice,
            Double maxPrice) {

        return productRepository.findByPriceBetween(
                minPrice,
                maxPrice
        );
    }

    @Override
    public List<Product> searchProducts(String keyword) {

        return productRepository
                .findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = getProductById(id);

        productRepository.delete(product);
    }
}