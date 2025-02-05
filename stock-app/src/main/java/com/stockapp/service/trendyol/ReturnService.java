package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.ReturnClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnService {

    private static final Logger logger = LoggerFactory.getLogger(ReturnService.class);

    @Autowired
    private ReturnClient returnClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String getReturnRequests() {
        logger.info("Getting return requests");
        String authorizationHeader = "Bearer " + apiKey;
        String response = returnClient.getReturnRequests(authorizationHeader);
        logger.info("Received return requests response: {}", response);
        return response;
    }

    public String getReturnRequestDetails(Long returnId) {
        logger.info("Getting details for return ID: {}", returnId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = returnClient.getReturnRequestDetails(returnId, authorizationHeader);
        logger.info("Received return request details response: {}", response);
        return response;
    }

    public String updateReturnStatus(Long returnId, String statusPayload) {
        logger.info("Updating return status for return ID: {}", returnId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = returnClient.updateReturnStatus(returnId, statusPayload, authorizationHeader, contentType);
        logger.info("Return status update response: {}", response);
        return response;
    }
}
