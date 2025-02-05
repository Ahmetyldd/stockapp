package com.stockapp.dto.product;

import com.stockapp.dto.trendyol.AttributeDto;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;

    private Long companyId;

    private boolean isTrendyolPublish;

    private boolean isHbPublish;

    private String barcode;

    private String title;

    private String productMainId;

    private Integer brandId;

    private Integer categoryId;

    private Integer quantity;

    private String stockCode;

    private Long dimensionalWeight;

    private String description;

    private String currencyType;

    private Long listPrice;

    private Long salePrice;

    private Integer cargoCompanyId;

    private Integer deliveryDuration;

    private List<String> images;

    private Integer vatRate;

    private Integer shipmentAddressId;

    private Integer returningAddressId;

    private Set<AttributeDto> attributeDtos;
}
