package com.stockapp.service.trendyol;

import com.stockapp.feignclient.trendyol.InvoiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    private InvoiceClient invoiceClient;

    private final String apiKey = "YOUR_API_KEY";  // Trendyol API Key

    public String getInvoices() {
        logger.info("Getting invoices");
        String authorizationHeader = "Bearer " + apiKey;
        String response = invoiceClient.getInvoices(authorizationHeader);
        logger.info("Received invoices response: {}", response);
        return response;
    }

    public String getPaymentStatus() {
        logger.info("Getting payment status");
        String authorizationHeader = "Bearer " + apiKey;
        String response = invoiceClient.getPaymentStatus(authorizationHeader);
        logger.info("Received payment status response: {}", response);
        return response;
    }
}
