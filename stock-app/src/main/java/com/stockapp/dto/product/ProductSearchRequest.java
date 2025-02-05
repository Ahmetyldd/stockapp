package com.stockapp.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequest {
    private List<String> productrs;
    private List<String> genders;
    private List<Integer> prices;
    private Boolean sortByPrice;
    private String productr;
    private String productGender;
}
