package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Email
    @Size(min = 3, max = 50)
    private String username;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String password;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;

    @NotNull
    private String userRole;




    public User(@NotEmpty @Email @Size(min = 3, max = 50) String username,
                @NotEmpty @Size(min = 3, max = 100) String password,
                boolean isActive,
                @NotNull String userRole) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.userRole = userRole;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(userRole, user.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, isActive, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}

