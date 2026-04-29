package com.pricing;

import com.pricing.model.*;

public class DiscountCalculator {
    private static final double VIP_EXTRA_DISCOUNT = 0.05;
    
    public double calculate(double subtotal, CustomerType customerType, DiscountCode discountCode) {
        double discount = subtotal * discountCode.getRate();
        
        if (customerType == CustomerType.VIP) {
            discount += subtotal * VIP_EXTRA_DISCOUNT;
        }
        
        return discount;
    }
}
