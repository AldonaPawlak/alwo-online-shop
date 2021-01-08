package com.alwo.enums;

public enum ContactTypeEnum {

    DELIVERY,
    INVOICE;

    public int getValue() {
        return ordinal() + 1;
    }
}
