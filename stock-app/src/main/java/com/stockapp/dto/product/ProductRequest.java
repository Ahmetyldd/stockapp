package com.stockapp.dto.product;

import com.stockapp.dto.trendyol.AttributeDto;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
public class ProductRequest {

    private Long id;

    private Long companyId;

    private boolean isTrendyolPublish;

    private boolean isHbPublish;

    @Size(max = 40)
    private String barcode;

    @Size(max = 100)
    private String title;

    @Size(max = 40)
    private String productMainId;

    private Integer brandId;

    private Integer categoryId;

    private Integer quantity;

    @Size(max = 100)
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

    private List<AttributeDto> attributes;
}
