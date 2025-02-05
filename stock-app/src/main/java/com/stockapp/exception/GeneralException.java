package com.stockapp.exception;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {
    private final String result;
    private final String resultCode;
    private final String resultDesc;


    public GeneralException(String result, String resultCode) {
        this.result = result;
        this.resultCode = resultCode;
        this.resultDesc = null;
    }

    public GeneralException(String result, String resultCode, String resultDesc) {
        this.result = result;
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }

}
