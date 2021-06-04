package com.stefan.salaryapp.util;

public enum Role {

    USER (1), ADMIN(2);

    private final int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
