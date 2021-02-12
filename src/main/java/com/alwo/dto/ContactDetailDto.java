package com.alwo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContactDetailDto {
    private String firstName;
    private String lastName;
    private String street;
    private String apartmentNumber;
    private String zipCode;
    private String city;
    private String description;
    private String contactType;
}
