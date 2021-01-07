package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String userRole;

    public UserRole(@NotEmpty @Size(min = 2, max = 10) String userRole) {
        this.userRole = userRole;
    }

    public UserRole() {
    }


}
