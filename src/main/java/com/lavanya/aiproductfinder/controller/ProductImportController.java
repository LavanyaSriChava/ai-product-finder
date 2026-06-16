package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.service.ProductImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductImportController {

    private final ProductImportService productImportService;

    public ProductImportController(
            ProductImportService productImportService) {

        this.productImportService = productImportService;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importProducts() {

        productImportService.importProducts();

        return ResponseEntity.ok(
                "Products imported successfully"
        );
    }
}