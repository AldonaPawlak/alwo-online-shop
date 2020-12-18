package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @NotEmpty
    @Email
    @Size(min = 3, max = 50)
    private String email;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String password;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;

    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JsonIgnoreProperties(value = "id")
    private UserRole role;

    @OneToMany
    @JoinColumn(name = "userId", updatable = false, insertable = false)
    private List<Order> orders = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "userId", updatable = false, insertable = false)
    private List<ContactDetail> contactDetails = new ArrayList<>();

    public User(@NotEmpty @Size(min = 2, max = 50) String name,
                @NotEmpty @Email @Size(min = 3, max = 50) String email,
                @NotEmpty @Size(min = 3, max = 100) String password,
                UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
}
