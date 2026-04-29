package com.pricing;

import java.util.*;

public class PricingEngine {
    public double calculate(String customerType, List<Double> prices, List<Integer> quantities, String discountCode) {
        // Calculate subtotal
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }
        
        // Calculate discount
        double discount = 0;
        if (discountCode.equals("SAVE10")) {
            discount = subtotal * 0.10;
        } else if (discountCode.equals("SAVE20")) {
            discount = subtotal * 0.20;
        }
        
        // VIP extra discount
        if (customerType.equals("VIP")) {
            discount += subtotal * 0.05;
        }
        
        // Calculate tax
        double tax = subtotal * 0.20;
        
        // Final price
        return subtotal - discount + tax;
    }
}
