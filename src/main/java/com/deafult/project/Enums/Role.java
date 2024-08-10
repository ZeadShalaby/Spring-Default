package com.deafult.project.Enums;

public enum Role {
    ADMIN(1),
    OWNER(2),
    CUSTOMER(3);

    private final int value;

    // Constructor
    Role(int value) {
        this.value = value;
    }

    // Getter method
    public int getValue() {
        return value;
    }
}
