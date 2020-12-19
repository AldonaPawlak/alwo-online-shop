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
    private Double taxRate;

    public Tax(String title, Double taxRate) {
        this.title = title;
        this.taxRate = taxRate;
    }

    public Tax() { }
}
