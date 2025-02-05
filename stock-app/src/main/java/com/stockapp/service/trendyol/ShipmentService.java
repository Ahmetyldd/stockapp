package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.ShipmentClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    private static final Logger logger = LoggerFactory.getLogger(ShipmentService.class);

    @Autowired
    private ShipmentClient shipmentClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String getShipmentStatus(Long shipmentId) {
        logger.info("Getting shipment status for shipment ID: {}", shipmentId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = shipmentClient.getShipmentStatus(shipmentId, authorizationHeader);
        logger.info("Received shipment status response: {}", response);
        return response;
    }

    public String createShipmentLabel(Long shipmentId, String labelPayload) {
        logger.info("Creating shipment label for shipment ID: {}", shipmentId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = shipmentClient.createShipmentLabel(shipmentId, labelPayload, authorizationHeader, contentType);
        logger.info("Shipment label creation response: {}", response);
        return response;
    }
}
