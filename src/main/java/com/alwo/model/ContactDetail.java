package com.alwo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = "contact_details")
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    User user;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    private String phone;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String street;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String apartmentNumber;

    @Size(min = 2, max = 10)
    private String zipCode;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String city;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ContactType contactType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    Order order;

    public ContactDetail(User user,
                         @NotEmpty @Size(min = 2, max = 50) String firstname,
                         @NotEmpty @Size(min = 2, max = 50) String lastName,
                         @NotEmpty @Email String email,
                         String phone,
                         @NotEmpty @Size(min = 2, max = 50) String street,
                         @NotEmpty @Size(min = 1, max = 10) String apartmentNumber,
                         @Size(min = 2, max = 10) String zipCode,
                         @NotEmpty @Size(min = 2, max = 20) String city,
                         String description,
                         ContactType contactType,
                         Order order) {
        this.user = user;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.description = description;
        this.contactType = contactType;
        this.order = order;
    }

    public ContactDetail() {
    }
}
