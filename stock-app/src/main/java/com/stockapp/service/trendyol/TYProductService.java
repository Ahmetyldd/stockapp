package com.stockapp.service.trendyol;

import com.stockapp.dto.trendyol.CreateProductsResponse;
import com.stockapp.dto.trendyol.TYProductDto;
import com.stockapp.feignclient.trendyol.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TYProductService {

    private static final Logger logger = LoggerFactory.getLogger(TYProductService.class);

    @Autowired
    private ProductClient productClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String getProducts(Long supplierId) {
        logger.info("Getting products for supplier ID: {}", supplierId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = productClient.getProducts(supplierId, authorizationHeader);
        logger.info("Received products response: {}", response);
        return response;
    }

    public String getProductDetails(Long productId) {
        logger.info("Getting details for product ID: {}", productId);
        String authorizationHeader = "Bearer " + apiKey;
        String response = productClient.getProductDetails(productId, authorizationHeader);
        logger.info("Received product details response: {}", response);
        return response;
    }

    public CreateProductsResponse addProduct(TYProductDto productPayload) {
        logger.info("Adding new product");
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        CreateProductsResponse response = productClient.addProduct(productPayload, authorizationHeader, contentType);
        logger.info("Product addition response: {}", response);
        return response;
    }

    public String updateProduct(Long productId, String productPayload) {
        logger.info("Updating product ID: {}", productId);
        String authorizationHeader = "Bearer " + apiKey;
        String contentType = "application/json";
        String response = productClient.updateProduct(productId, productPayload, authorizationHeader, contentType);
        logger.info("Product update response: {}", response);
        return response;
    }
}