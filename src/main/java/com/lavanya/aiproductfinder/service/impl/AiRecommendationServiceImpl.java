package com.lavanya.aiproductfinder.service.impl;

import com.lavanya.aiproductfinder.external.OpenRouterClient;
import com.lavanya.aiproductfinder.service.AiRecommendationService;
import org.springframework.stereotype.Service;

@Service
public class AiRecommendationServiceImpl
        implements AiRecommendationService {

    private final OpenRouterClient openRouterClient;

    public AiRecommendationServiceImpl(
            OpenRouterClient openRouterClient) {

        this.openRouterClient = openRouterClient;
    }

    @Override
    public String interpretUserQuery(String query) {

        String prompt = """
                You are an AI product recommendation assistant.

                Analyze this query and recommend suitable products:

                %s
                """.formatted(query);

        return openRouterClient.askAI(prompt);
    }
}