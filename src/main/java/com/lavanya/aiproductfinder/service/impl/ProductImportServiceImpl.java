package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.dto.DummyJsonResponse;
import com.lavanya.aiproductfinder.dto.DummyProduct;
import com.lavanya.aiproductfinder.entity.Product;
import com.lavanya.aiproductfinder.external.ProductApiClient;
import com.lavanya.aiproductfinder.repository.ProductRepository;
import com.lavanya.aiproductfinder.service.ProductImportService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductImportServiceImpl
        implements ProductImportService {

    private final ProductApiClient productApiClient;
    private final ProductRepository productRepository;

    public ProductImportServiceImpl(
            ProductApiClient productApiClient,
            ProductRepository productRepository) {

        this.productApiClient = productApiClient;
        this.productRepository = productRepository;
    }

    @Override
    public void importProducts() {

        DummyJsonResponse response =
                productApiClient.fetchProducts();

        if (response == null ||
                response.getProducts() == null) {
            return;
        }

        for (DummyProduct dummyProduct :
                response.getProducts()) {

            Product product = Product.builder()
                    .title(dummyProduct.getTitle())
                    .brand(
                            dummyProduct.getBrand() != null
                                    ? dummyProduct.getBrand()
                                    : "Unknown"
                    )
                    .category(dummyProduct.getCategory())
                    .price(dummyProduct.getPrice())
                    .rating(dummyProduct.getRating())
                    .description(dummyProduct.getDescription())
                    .imageUrl(dummyProduct.getThumbnail())
                    .createdAt(LocalDateTime.now())
                    .build();

            productRepository.save(product);
        }
    }
}