package com.lavanya.aiproductfinder.external;

import com.lavanya.aiproductfinder.dto.DummyJsonResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductApiClient {

    private static final String PRODUCTS_URL =
            "https://dummyjson.com/products";

    private final RestTemplate restTemplate;

    public ProductApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public DummyJsonResponse fetchProducts() {

        return restTemplate.getForObject(
                PRODUCTS_URL,
                DummyJsonResponse.class
        );
    }
}