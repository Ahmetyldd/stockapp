package com.stockapp.enums;

public enum OrderStatusType {

    PENDING(1),
    ACTIVE(2),
    PASSIVE(3),
    TEMPORARY(4);


    public final Integer value;

    private OrderStatusType(Integer value) {
        this.value = value;
    }
}
