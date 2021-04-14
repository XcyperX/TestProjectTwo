package com.spring.TestProject.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("Администратор"),
    USER("Пользователь");

    private String role;

    Role(String gender) {
        this.role = gender;
    }

    public String getNameRole() {
        return role;
    }

    public static String getById(Long id) {
        for (Role role : values()) {
            if (role.ordinal() == id) {
                return role.getNameRole();
            }
        }
        return "UNKNOWN";
    }

    @Override
    public String getAuthority() {
        return getNameRole();
    }
}
