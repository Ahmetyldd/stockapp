package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.PriceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    private static final Logger logger = LoggerFactory.getLogger(PriceService.class);

    @Autowired
    private PriceClient priceClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String updatePrice(Long productId, String pricePayload) {
        logger.info("Updating price for product ID: {}", productId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = priceClient.updatePrice(productId, pricePayload, authorizationHeader, contentType);
        logger.info("Price update response: {}", response);
        return response;
    }

    public String getPrices() {
        logger.info("Getting price information");
        String authorizationHeader = "Bearer " + apiKey;
        String response = priceClient.getPrices(authorizationHeader);
        logger.info("Received price information response: {}", response);
        return response;
    }
}
