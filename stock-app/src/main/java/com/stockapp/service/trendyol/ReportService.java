package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.ReportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    private ReportClient reportClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String getSalesReports() {
        logger.info("Getting sales reports");
        String authorizationHeader = "Bearer " + apiKey;
        String response = reportClient.getSalesReports(authorizationHeader);
        logger.info("Received sales reports response: {}", response);
        return response;
    }

    public String getProductReports() {
        logger.info("Getting product reports");
        String authorizationHeader = "Bearer " + apiKey;
        String response = reportClient.getProductReports(authorizationHeader);
        logger.info("Received product reports response: {}", response);
        return response;
    }
}
