package com.stockapp.dto.product;

import com.stockapp.enums.SearchProduct;
import lombok.Data;

@Data
public class SearchTypeRequest {
    private SearchProduct searchType;
    private String text;
}
