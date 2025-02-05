package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "invoiceClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface InvoiceClient {

    @GetMapping("/invoices")
    String getInvoices(@RequestHeader("Authorization") String authorization);

    @GetMapping("/payments")
    String getPaymentStatus(@RequestHeader("Authorization") String authorization);
}
