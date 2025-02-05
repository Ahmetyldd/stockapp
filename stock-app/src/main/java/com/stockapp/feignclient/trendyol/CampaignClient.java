package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "campaignClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface CampaignClient {

    @PostMapping("/campaigns")
    String createCampaign(@RequestBody String campaignPayload,
                          @RequestHeader("Authorization") String authorization,
                          @RequestHeader("Content-Type") String contentType);

    @PutMapping("/campaigns/{campaignId}")
    String updateCampaign(@PathVariable("campaignId") Long campaignId,
                          @RequestBody String campaignPayload,
                          @RequestHeader("Authorization") String authorization,
                          @RequestHeader("Content-Type") String contentType);

    @GetMapping("/campaigns")
    String listCampaigns(@RequestHeader("Authorization") String authorization);
}
