package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "priceClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface PriceClient {

    @PutMapping("/products/{productId}/price")
    String updatePrice(@PathVariable("productId") Long productId,
                       @RequestBody String pricePayload,
                       @RequestHeader("Authorization") String authorization,
                       @RequestHeader("Content-Type") String contentType);

    @GetMapping("/products/prices")
    String getPrices(@RequestHeader("Authorization") String authorization);
}
