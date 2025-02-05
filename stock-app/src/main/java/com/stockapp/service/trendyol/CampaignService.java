package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.CampaignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    private static final Logger logger = LoggerFactory.getLogger(CampaignService.class);

    @Autowired
    private CampaignClient campaignClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String createCampaign(String campaignPayload) {
        logger.info("Creating new campaign");
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = campaignClient.createCampaign(campaignPayload, authorizationHeader, contentType);
        logger.info("Campaign creation response: {}", response);
        return response;
    }

    public String updateCampaign(Long campaignId, String campaignPayload) {
        logger.info("Updating campaign ID: {}", campaignId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = campaignClient.updateCampaign(campaignId, campaignPayload, authorizationHeader, contentType);
        logger.info("Campaign update response: {}", response);
        return response;
    }

    public String listCampaigns() {
        logger.info("Listing campaigns");
        String authorizationHeader = "Bearer " + apiKey;
        String response = campaignClient.listCampaigns(authorizationHeader);
        logger.info("Received campaigns response: {}", response);
        return response;
    }
}
