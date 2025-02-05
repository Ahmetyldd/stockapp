package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.StockClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private static final Logger logger = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private StockClient stockClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String updateStock(Long supplierId, String stockPayload) {
        logger.info("Updating stock for supplier ID: {}", supplierId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = stockClient.updateStock(supplierId, stockPayload, authorizationHeader, contentType);
        logger.info("Stock update response: {}", response);
        return response;
    }

    public String getStockLevel(Long productId) {
        logger.info("Getting stock level for product ID: {}", productId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = stockClient.getStockLevel(productId, authorizationHeader);
        logger.info("Received stock level response: {}", response);
        return response;
    }
}
