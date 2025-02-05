package com.stockapp.dto.trendyol;

import lombok.Data;

@Data
public class FailedItem {
    private String barcode;
    private String reason;
    private AttributeResponse attributes;
}
