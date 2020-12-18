package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "taxes")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double taxRate;

    public Tax(String title, String description, Double taxRate) {
        this.title = title;
        this.description = description;
        this.taxRate = taxRate;
    }

    public Tax() { }
}
