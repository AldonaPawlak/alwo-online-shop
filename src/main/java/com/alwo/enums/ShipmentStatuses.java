package com.alwo.enums;

public enum ShipmentStatuses {
    PACKED, PICKEDUP, SHIPPED, DELIVERED, INITIAL;

    public int getValue() {
        return ordinal() + 1;
    }
}
