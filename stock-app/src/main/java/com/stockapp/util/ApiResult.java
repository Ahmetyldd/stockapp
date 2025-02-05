package com.stockapp.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResult {
    private String result;
    private String resultCode;
    private String resultDesc;
}
