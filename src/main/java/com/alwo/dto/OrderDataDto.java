package com.alwo.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderDataDto {
    private long paymentId;
    private long shipmentId;
    private List<ContactDetailDto> addresses;
    private List<OrderedProductResponse> orderedProducts;
}
