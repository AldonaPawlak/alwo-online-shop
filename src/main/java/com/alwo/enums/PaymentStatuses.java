package com.alwo.enums;

public enum PaymentStatuses {
    PROCESSED, FAILED, WAITING;

    public int getValue() {
        return ordinal() + 1;
    }
}
