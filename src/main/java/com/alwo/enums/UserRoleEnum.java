package com.alwo.enums;

public enum UserRoleEnum {

    ADMIN,
    CUSTOMER;

    public int getValue() {
        return ordinal() + 1;
    }

}
