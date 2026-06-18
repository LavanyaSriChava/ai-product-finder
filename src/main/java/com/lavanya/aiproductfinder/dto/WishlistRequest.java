package com.lavanya.aiproductfinder.dto;

import lombok.Data;

@Data
public class WishlistRequest {

    private String query;

    private String recommendation;
}