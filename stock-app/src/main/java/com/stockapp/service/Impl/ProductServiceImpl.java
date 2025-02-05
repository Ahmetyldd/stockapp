package com.stockapp.service.Impl;

import com.stockapp.constants.ErrorMessage;
import com.stockapp.domain.TYProduct;
import com.stockapp.dto.product.ProductRequest;
import com.stockapp.dto.product.ProductResponse;
import com.stockapp.dto.trendyol.CreateProductsResponse;
import com.stockapp.dto.trendyol.TYProductDto;
import com.stockapp.enums.ProductStatusType;
import com.stockapp.exception.ApiRequestException;
import com.stockapp.exception.GeneralException;
import com.stockapp.exception.InputFieldException;
import com.stockapp.mapper.ProductMapper;
import com.stockapp.repository.ProductRepository;
import com.stockapp.service.ProductService;
import com.stockapp.service.trendyol.TYProductService;
import com.stockapp.util.ApiResult;
import com.stockapp.util.StockUtil;
import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

import static com.stockapp.constants.ErrorMessage.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final TYProductService tyProductService;

    @Override
    public ProductResponse getProductById(Long productId) {
        TYProduct product = productRepository.findById(productId).orElse(null);
        return ProductMapper.INSTANCE.entityToDto(product);
    }

    @Override
    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        Page<TYProduct> products = productRepository.findAllByOrderByIdAsc(pageable);
        return products.map(ProductMapper.INSTANCE::entityToDto);
    }

    @Override
    public Page<ProductResponse> getAllProductsByCompanyIdAndStatus(Long companyId, Integer status, Pageable pageable) {
        Page<TYProduct> products = productRepository.findByCompanyIdAndStatus(companyId, status, pageable);
        return products.map(ProductMapper.INSTANCE::entityToDto);
    }

    @Override
    public Page<ProductResponse> getAllProductsByCompanyId(Long companyId, Pageable pageable) {
        Page<TYProduct> products = productRepository.findByCompanyId(companyId, pageable);
        return products.map(ProductMapper.INSTANCE::entityToDto);
    }

    @Override
    public List<TYProduct> getProductsByIds(List<Long> productsId) {
        return productRepository.getProductsByIds(productsId);
    }

    @Override
    @Transactional
    public ApiResult saveProduct(ProductRequest productRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("There was error when insert product : {} ", bindingResult);
            return StockUtil.createFailResponse(GENERAL_FAIL_CODE, bindingResult.toString());
        }
        TYProduct product = ProductMapper.INSTANCE.toEntity(productRequest);
        product.setStatus(ProductStatusType.PENDING.getValue());
        log.info("Saving product: {}", product);
        productRepository.save(product);
        return StockUtil.createSuccessResponse();
    }

    @Override
    @Transactional
    public ApiResult deleteProduct(Long productId) {
        TYProduct tyProduct = productRepository.findById(productId).orElse(null);
        if (tyProduct == null) {
            return StockUtil.createFailResponse(GENERAL_FAIL_CODE, GENERAL_FAIL_MESSAGE);
        }
        productRepository.deleteById(tyProduct.getId());
        return StockUtil.createSuccessResponse();
    }

    @Override
    public DataFetcher<TYProduct> getProductByQuery() {
        return dataFetchingEnvironment -> {
            Long productId = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
            return productRepository.findById(productId).get();
        };
    }

    @Override
    public DataFetcher<List<TYProduct>> getAllProductsByQuery() {
        return dataFetchingEnvironment -> productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public DataFetcher<List<TYProduct>> getAllProductsByIdsQuery() {
        return dataFetchingEnvironment -> {
            List<String> objects = dataFetchingEnvironment.getArgument("ids");
            List<Long> productsId = objects.stream()
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            return productRepository.findByIdIn(productsId);
        };
    }

    public ApiResult approveProduct(Long productId) {

        TYProduct product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new GeneralException("Data not found with productId : {}" + productId, ErrorMessage.GENERAL_FAIL_CODE);
        }

        if (product.isTrendyolPublish()) {
            CreateProductsResponse createProductsResponse = tyProductService.addProduct(ProductMapper.INSTANCE.entityToTYDto(product));
            if (!createProductsResponse.isSuccess()) {
                log.error("Trendyol error response : {}", createProductsResponse);
                return StockUtil.createFailResponse(TY_FAIL_CODE, createProductsResponse.getMessage());
            }
        }

        product.setStatus(ProductStatusType.ACTIVE.value);
        productRepository.save(product);

        return StockUtil.createSuccessResponse();
    }

}
