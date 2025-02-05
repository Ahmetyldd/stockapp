package com.stockapp.dto.trendyol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TYProductDto {

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

    private String deliveryOption;

    private List<String> images;

    private Integer vatRate;

    private Integer shipmentAddressId;

    private Integer returningAddressId;

    private List<AttributeDto> attributeDtos;

}
