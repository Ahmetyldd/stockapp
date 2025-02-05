package com.stockapp.feignclient.trendyol;

import com.stockapp.dto.trendyol.CreateProductsResponse;
import com.stockapp.dto.trendyol.TYProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "productClient", url = "https://api.trendyol.com/sapigw/suppliers")
public interface ProductClient {

    @GetMapping("/{supplierId}/products")
    String getProducts(@PathVariable("supplierId") Long supplierId,
                       @RequestHeader("Authorization") String authorization);

    @GetMapping("/products/{productId}")
    String getProductDetails(@PathVariable("productId") Long productId,
                             @RequestHeader("Authorization") String authorization);

    @PostMapping("/products")
    CreateProductsResponse addProduct(@RequestBody TYProductDto productPayload,
                                      @RequestHeader("Authorization") String authorization,
                                      @RequestHeader("Content-Type") String contentType);

    @PutMapping("/products/{productId}")
    String updateProduct(@PathVariable("productId") Long productId,
                         @RequestBody String productPayload,
                         @RequestHeader("Authorization") String authorization,
                         @RequestHeader("Content-Type") String contentType);

    @DeleteMapping("/products/{productId}")
    String deleteProduct(@PathVariable("productId") Long productId,
                         @RequestHeader("Authorization") String authorization);
}
