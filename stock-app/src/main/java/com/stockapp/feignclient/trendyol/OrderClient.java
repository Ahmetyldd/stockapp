package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "orderClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface OrderClient {

    @GetMapping("/{supplierId}/orders")
    String getOrders(@PathVariable("supplierId") Long supplierId,
                     @RequestHeader("Authorization") String authorization);

    @GetMapping("/orders/{orderId}")
    String getOrderDetails(@PathVariable("orderId") Long orderId,
                           @RequestHeader("Authorization") String authorization);

    @PutMapping("/orders/{orderId}/status")
    String updateOrderStatus(@PathVariable("orderId") Long orderId,
                             @RequestBody String statusPayload,
                             @RequestHeader("Authorization") String authorization,
                             @RequestHeader("Content-Type") String contentType);

    @GetMapping("/orders/returns")
    String getReturnRequests(@RequestHeader("Authorization") String authorization);

    @GetMapping("/orders/returns/{returnId}")
    String getReturnRequestDetails(@PathVariable("returnId") Long returnId,
                                   @RequestHeader("Authorization") String authorization);

    @PostMapping("/orders/{orderId}/invoice")
    String createInvoice(@PathVariable("orderId") Long orderId,
                         @RequestBody String invoicePayload,
                         @RequestHeader("Authorization") String authorization,
                         @RequestHeader("Content-Type") String contentType);
}
