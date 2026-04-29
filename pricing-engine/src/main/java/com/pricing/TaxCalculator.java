package com.pricing;

public class TaxCalculator {
    private static final double TAX_RATE = 0.20;
    
    public double calculate(double subtotal) {
        return subtotal * TAX_RATE;
    }
}
