package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "stockClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface StockClient {

    @PutMapping("/{supplierId}/products/stock")
    String updateStock(@PathVariable("supplierId") Long supplierId,
                       @RequestBody String stockPayload,
                       @RequestHeader("Authorization") String authorization,
                       @RequestHeader("Content-Type") String contentType);

    @GetMapping("/products/{productId}/stock")
    String getStockLevel(@PathVariable("productId") Long productId,
                         @RequestHeader("Authorization") String authorization);
}
