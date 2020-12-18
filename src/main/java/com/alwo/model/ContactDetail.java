package com.alwo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "contact_details")
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String street;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String apartmentNumber;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String zipCode;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String city;

    private String description;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ContactType contactType;


    public ContactDetail(Long userId,
                         @NotEmpty @Size(min = 2, max = 50) String firstname,
                         @NotEmpty @Size(min = 2, max = 50) String lastName,
                         @NotEmpty @Size(min = 2, max = 50) String street,
                         @NotEmpty @Size(min = 1, max = 10) String apartmentNumber,
                         @NotEmpty @Size(min = 2, max = 10) String zipCode,
                         @NotEmpty @Size(min = 2, max = 10) String city,
                         String description,
                         ContactType contactType) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastName = lastName;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.description = description;
        this.contactType = contactType;
    }

    public ContactDetail() {
    }
}
