package com.stockapp.enums;

public enum CompanyStatusType {

    ACTIVE(1),
    PASSIVE(2);

    public final Integer value;

    private CompanyStatusType(Integer value) {
        this.value = value;
    }
}
