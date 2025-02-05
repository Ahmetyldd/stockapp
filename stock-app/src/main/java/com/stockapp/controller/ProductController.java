package com.stockapp.controller;

import java.util.List;

import com.stockapp.domain.TYProduct;
import com.stockapp.service.ProductService;
import com.stockapp.util.ApiResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.stockapp.dto.GraphQLRequest;
import com.stockapp.dto.HeaderResponse;
import com.stockapp.dto.product.*;
import com.stockapp.mapper.ProductMapper;
import com.stockapp.service.graphql.GraphQLProvider;

import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import static com.stockapp.constants.PathConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PERFUMES)
public class ProductController {

    private final ProductService productService;
    private final GraphQLProvider graphQLProvider;

    @PostMapping(ADD)
    public ResponseEntity<ApiResult> addProduct(@RequestBody @Valid ProductRequest product,
                                                BindingResult bindingResult) {
        return ResponseEntity.ok(productService.saveProduct(product, bindingResult));
    }

    @PostMapping(EDIT)
    public ResponseEntity<ApiResult> updateProduct(@RequestPart("product") @Valid ProductRequest product,
                                                             BindingResult bindingResult) {
        return ResponseEntity.ok(productService.saveProduct(product, bindingResult));
    }

    @GetMapping(GETALL_PRODUCT_BYCOMPANY)
    public ResponseEntity<Page<ProductResponse>> getAllProducts(@PageableDefault(size = 15) Pageable pageable) {
        Page<ProductResponse> response = productService.getAllProducts(pageable);

        return ResponseEntity.ok(response);
    }

    @GetMapping(GETALL_PRODUCT_BYCOMPANY_ANDSTATUS)
    public ResponseEntity<Page<ProductResponse>> getAllProductsByCompanyIdAndStatus(@RequestParam("companyId") Long companyId, @RequestParam("status") Integer status, @PageableDefault(size = 15) Pageable pageable) {
        Page<ProductResponse> response = productService.getAllProductsByCompanyIdAndStatus(companyId, status, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAllProductsByCompanyId(@RequestParam("companyId") Long companyId, @PageableDefault(size = 15) Pageable pageable) {
        Page<ProductResponse> response = productService.getAllProductsByCompanyId(companyId, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping(PRODUCT_ID)
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId) {
        ProductResponse product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PostMapping(GRAPHQL_IDS)
    public ResponseEntity<ExecutionResult> getProductsByIdsQuery(@RequestBody GraphQLRequest request) {
        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
    }

    @PostMapping(GRAPHQL_PERFUMES)
    public ResponseEntity<ExecutionResult> getAllProductsByQuery(@RequestBody GraphQLRequest request) {
        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
    }

    @PostMapping(GRAPHQL_PERFUME)
    public ResponseEntity<ExecutionResult> getProductByQuery(@RequestBody GraphQLRequest request) {
        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
    }
}
