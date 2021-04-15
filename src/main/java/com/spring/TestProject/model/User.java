package com.spring.TestProject.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String secondName;

    @Column(unique = true)
    private String login;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Form> forms = new ArrayList<>();

    private String password;

    private Role role;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return getFirstName() + " " + getLastName() + " " + getSecondName();
    }

    public String getUserRole() {
        return getRole().getNameRole();
    }

    public Boolean isAdmin() {
        return role.name().contains("ADMIN");
    }

    public Boolean isUser() {
        return role.name().contains("USER");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
