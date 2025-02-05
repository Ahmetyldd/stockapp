package com.stockapp.enums;

public enum ProductStatusType {

    ACTIVE(2),
    PENDING(1),
    PASSIVE(0);

    public final Integer value;

    private ProductStatusType(Integer value) {
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
