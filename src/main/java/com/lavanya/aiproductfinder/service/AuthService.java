package com.lavanya.aiproductfinder.service;

import com.lavanya.aiproductfinder.dto.AuthResponse;
import com.lavanya.aiproductfinder.dto.LoginRequest;
import com.lavanya.aiproductfinder.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}