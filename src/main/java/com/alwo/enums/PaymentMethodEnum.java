package com.alwo.enums;

public enum PaymentMethodEnum {
    BANK_TRANSFER, PAYU, CASH;

    public int getValue() {
        return ordinal() + 1;
    }
}
