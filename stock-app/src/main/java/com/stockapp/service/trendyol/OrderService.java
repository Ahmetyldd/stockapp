package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.OrderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderClient orderClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String getOrders(Long supplierId) {
        logger.info("Getting orders for supplier ID: {}", supplierId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = orderClient.getOrders(supplierId, authorizationHeader);
        logger.info("Received orders response: {}", response);
        return response;
    }

    public String getOrderDetails(Long orderId) {
        logger.info("Getting details for order ID: {}", orderId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = orderClient.getOrderDetails(orderId, authorizationHeader);
        logger.info("Received order details response: {}", response);
        return response;
    }

    public String updateOrderStatus(Long orderId, String statusPayload) {
        logger.info("Updating status for order ID: {}", orderId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = orderClient.updateOrderStatus(orderId, statusPayload, authorizationHeader, contentType);
        logger.info("Order status update response: {}", response);
        return response;
    }

    public String getReturnRequests() {
        logger.info("Getting return requests");
        String authorizationHeader = "Bearer " + apiKey;
        String response = orderClient.getReturnRequests(authorizationHeader);
        logger.info("Received return requests response: {}", response);
        return response;
    }

    public String getReturnRequestDetails(Long returnId) {
        logger.info("Getting details for return ID: {}", returnId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = orderClient.getReturnRequestDetails(returnId, authorizationHeader);
        logger.info("Received return request details response: {}", response);
        return response;
    }

    public String createInvoice(Long orderId, String invoicePayload) {
        logger.info("Creating invoice for order ID: {}", orderId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = orderClient.createInvoice(orderId, invoicePayload, authorizationHeader, contentType);
        logger.info("Invoice creation response: {}", response);
        return response;
    }
}
