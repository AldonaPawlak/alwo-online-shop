package com.alwo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactDetailDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String street;
    private String apartmentNumber;
    private String zipCode;
    private String city;
    private String description;
    private String contactType;

    public ContactDetailDto(Long id,
                            String firstName,
                            String lastName,
                            String email,
                            String phone,
                            String street,
                            String apartmentNumber,
                            String zipCode,
                            String city,
                            String description,
                            String contactType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.description = description;
        this.contactType = contactType;
    }

    public ContactDetailDto() {
    }
}
