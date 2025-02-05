package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.StoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

    @Autowired
    private StoreClient storeClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String getStoreInfo() {
        logger.info("Getting store information");
        String authorizationHeader = "Bearer " + apiKey;
        String response = storeClient.getStoreInfo(authorizationHeader);
        logger.info("Received store information response: {}", response);
        return response;
    }

    public String updateStoreStatus(String statusPayload) {
        logger.info("Updating store status");
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = storeClient.updateStoreStatus(statusPayload, authorizationHeader, contentType);
        logger.info("Store status update response: {}", response);
        return response;
    }
}
