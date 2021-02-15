package com.alwo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentDto {

    Long id;
    String name;
    String description;
    String url;

    public PaymentDto() {
    }

    public PaymentDto(Long id, String name, String description, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
    }
}
