package com.stockapp.service;

import com.stockapp.domain.TYProduct;
import com.stockapp.dto.product.ProductRequest;
import com.stockapp.dto.product.ProductResponse;
import com.stockapp.dto.trendyol.TYProductDto;
import com.stockapp.util.ApiResult;
import graphql.schema.DataFetcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductService {

    ProductResponse getProductById(Long productId);

    Page<ProductResponse> getAllProducts(Pageable pageable);
    Page<ProductResponse> getAllProductsByCompanyIdAndStatus(Long companyId, Integer status, Pageable pageable);
    Page<ProductResponse> getAllProductsByCompanyId(Long companyId, Pageable pageable);

    List<TYProduct> getProductsByIds(List<Long> productsId);

    ApiResult saveProduct(ProductRequest request, BindingResult bindingResult);
    ApiResult approveProduct(Long productId);

    ApiResult deleteProduct(Long productId);

    DataFetcher<TYProduct> getProductByQuery();

    DataFetcher<List<TYProduct>> getAllProductsByQuery();

    DataFetcher<List<TYProduct>> getAllProductsByIdsQuery();
}
