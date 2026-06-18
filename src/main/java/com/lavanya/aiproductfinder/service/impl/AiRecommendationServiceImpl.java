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
    public String compareProducts(
            String product1,
            String product2) {

        String prompt = """
Compare these two products:

Product 1: %s
Product 2: %s

Give the comparison in EXACTLY this format:

📱 %s

✅ Pros
- Point 1
- Point 2
- Point 3

❌ Cons
- Point 1
- Point 2

📱 %s

✅ Pros
- Point 1
- Point 2
- Point 3

❌ Cons
- Point 1
- Point 2

🏆 Winner
One short paragraph (maximum 3 lines) explaining which product is better.

Rules:
- Keep total response under 150 words.
- Maximum 3 pros and 2 cons per product.
- Use bullet points only.
- No markdown tables.
- No HTML tags.
- No long explanations.
- No unnecessary introductions.
- Keep it mobile friendly and concise.
"""
                .formatted(
                        product1,
                        product2,
                        product1,
                        product2
                );
        return openRouterClient
                .askAI(prompt);
    }

    @Override
    public String interpretUserQuery(String query) {

        String prompt = """
You are an AI Product Recommendation Assistant.

Analyze the user's query and provide helpful recommendations.

Rules:
- Recommend the top 3 products.
- Explain why each product is suitable.
- Mention key specifications.
- Mention approximate price.
- Give a final verdict.
- Keep the response between 250-400 words.
- Use clean Markdown formatting.
- Use headings and bullet points.
- Do not use tables.

User Query:
%s
""".formatted(query);
        return openRouterClient.askAI(prompt);
    }
}