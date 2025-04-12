package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.common;

import lombok.Getter;

@Getter
public enum UserRole {
    DENTIST("ROLE_DENTIST"),
    PATIENT("ROLE_PATIENT"),
    OFFICE_MANAGER("ROLE_OFFICE_MANAGER");

    private final String authority;

    UserRole(final String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return String.valueOf(authority);
    }
}
