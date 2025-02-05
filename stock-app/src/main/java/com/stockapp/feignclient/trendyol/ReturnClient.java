package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "returnClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface ReturnClient {

    @GetMapping("/returns")
    String getReturnRequests(@RequestHeader("Authorization") String authorization);

    @GetMapping("/returns/{returnId}")
    String getReturnRequestDetails(@PathVariable("returnId") Long returnId,
                                   @RequestHeader("Authorization") String authorization);

    @PutMapping("/returns/{returnId}/status")
    String updateReturnStatus(@PathVariable("returnId") Long returnId,
                              @RequestBody String statusPayload,
                              @RequestHeader("Authorization") String authorization,
                              @RequestHeader("Content-Type") String contentType);
}
