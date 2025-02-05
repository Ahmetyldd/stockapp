package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "storeClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface StoreClient {

    @GetMapping("/store")
    String getStoreInfo(@RequestHeader("Authorization") String authorization);

    @PutMapping("/store/status")
    String updateStoreStatus(@RequestBody String statusPayload,
                             @RequestHeader("Authorization") String authorization,
                             @RequestHeader("Content-Type") String contentType);
}
