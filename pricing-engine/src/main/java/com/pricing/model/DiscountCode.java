package com.pricing.model;

public enum DiscountCode {
    SAVE10(0.10),
    SAVE20(0.20),
    NONE(0.0);
    
    private final double rate;
    
    DiscountCode(double rate) {
        this.rate = rate;
    }
    
    public double getRate() {
        return rate;
    }
    
    public static DiscountCode fromString(String code) {
        if (code == null || code.isEmpty()) {
            return NONE;
        }
        try {
            return DiscountCode.valueOf(code.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
