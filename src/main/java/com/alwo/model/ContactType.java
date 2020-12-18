package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "contact_types")
public class ContactType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String contactType;

    public ContactType(@NotEmpty @Size(min = 2, max = 10) String contactType) {
        this.contactType = contactType;
    }

    public ContactType() {
    }


}