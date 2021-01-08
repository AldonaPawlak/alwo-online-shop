package com.alwo.enums;

public enum OrderStatuses {

    INCOMPLETE, COMPLETE, BACKORDERED, CANCELED, DECLINED;

    public int getValue() {
        return ordinal() + 1;
    }
}
