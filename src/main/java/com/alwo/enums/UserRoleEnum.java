package com.alwo.enums;

public enum UserRoleEnum {

    ADMIN,
    CUSTOMER,
    TEMPORARY;

    public int getValue() {
        return ordinal() + 1;
    }

}
