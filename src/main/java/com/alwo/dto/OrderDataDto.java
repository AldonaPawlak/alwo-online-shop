package com.alwo.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderDataDto {
    private long shipmentMethod;
    private long paymentMethod;
    private List<ContactDetailDto> addresses;
}
