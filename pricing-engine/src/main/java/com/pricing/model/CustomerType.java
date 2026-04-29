package com.pricing.model;

public enum CustomerType {
    REGULAR,
    VIP;
    
    public static CustomerType fromString(String type) {
        try {
            return CustomerType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return REGULAR;
        }
    }
}
