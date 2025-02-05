package com.stockapp.feignclient.trendyol;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "shipmentClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface ShipmentClient {

    @GetMapping("/shipments/{shipmentId}")
    String getShipmentStatus(@PathVariable("shipmentId") Long shipmentId,
                             @RequestHeader("Authorization") String authorization);

    @PostMapping("/shipments/{shipmentId}/label")
    String createShipmentLabel(@PathVariable("shipmentId") Long shipmentId,
                               @RequestBody String labelPayload,
                               @RequestHeader("Authorization") String authorization,
                               @RequestHeader("Content-Type") String contentType);
}
