package com.alwo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderedProductResponse {

    private Long productId;
    private int quantity;


    public OrderedProductResponse(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderedProductResponse() {
    }
}
