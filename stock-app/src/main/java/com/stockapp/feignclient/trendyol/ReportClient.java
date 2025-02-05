package com.stockapp.feignclient.trendyol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "reportClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface ReportClient {

    @GetMapping("/reports/sales")
    String getSalesReports(@RequestHeader("Authorization") String authorization);

    @GetMapping("/reports/products")
    String getProductReports(@RequestHeader("Authorization") String authorization);
}
