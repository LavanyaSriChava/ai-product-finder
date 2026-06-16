package com.lavanya.aiproductfinder.controller;

import com.lavanya.aiproductfinder.dto.DashboardResponse;
import com.lavanya.aiproductfinder.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(
            AnalyticsService analyticsService) {

        this.analyticsService = analyticsService;
    }

    @GetMapping
    public ResponseEntity<DashboardResponse>
    getDashboardStats() {

        return ResponseEntity.ok(
                analyticsService.getDashboardStats()
        );
    }
}