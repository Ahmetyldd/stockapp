package com.stockapp.util;

import com.stockapp.enums.ResultType;
import org.springframework.stereotype.Component;

import static com.stockapp.constants.ErrorMessage.*;

@Component
public class StockUtil {

    public static ApiResult createSuccessResponse() {
        return ApiResult.builder()
                .result(ResultType.SUCCESS.name())
                .resultCode(GENERAL_SUCCESS_CODE)
                .resultDesc(GENERAL_SUCCESS_MESSAGE)
                .build();
    }

    public static ApiResult createFailResponse() {
        return ApiResult.builder()
                .result(ResultType.FAIL.name())
                .resultCode(GENERAL_FAIL_CODE)
                .resultDesc(GENERAL_FAIL_MESSAGE)
                .build();
    }

    public static ApiResult createFailResponse(String resultCode, String resultDesc) {
        return ApiResult.builder()
                .result(ResultType.FAIL.name())
                .resultCode(resultCode)
                .resultDesc(resultDesc)
                .build();
    }
}
