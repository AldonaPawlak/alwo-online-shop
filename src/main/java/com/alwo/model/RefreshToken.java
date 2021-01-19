package com.alwo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Setter
@Getter
@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Instant createdDate;

    public RefreshToken(String token, Instant createdDate) {
        this.token = token;
        this.createdDate = createdDate;
    }

    public RefreshToken() {
    }
}
