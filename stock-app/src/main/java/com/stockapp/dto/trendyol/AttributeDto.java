package com.stockapp.dto.trendyol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDto {

    private Integer attributeId;
    private Integer attributeValueId;
    private String customAttributeValue;
}
