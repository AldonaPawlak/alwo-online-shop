package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isActive;

    public Supplier(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public Supplier(){ }
}
