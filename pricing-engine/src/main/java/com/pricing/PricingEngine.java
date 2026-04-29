package com.pricing;

import com.pricing.model.*;
import java.util.List;

public class PricingEngine {
    private final SubtotalCalculator subtotalCalculator;
    private final DiscountCalculator discountCalculator;
    private final TaxCalculator taxCalculator;
    
    public PricingEngine() {
        this.subtotalCalculator = new SubtotalCalculator();
        this.discountCalculator = new DiscountCalculator();
        this.taxCalculator = new TaxCalculator();
    }
    
    // Constructor for dependency injection (testing)
    public PricingEngine(SubtotalCalculator subtotalCalculator, 
                        DiscountCalculator discountCalculator, 
                        TaxCalculator taxCalculator) {
        this.subtotalCalculator = subtotalCalculator;
        this.discountCalculator = discountCalculator;
        this.taxCalculator = taxCalculator;
    }
    
    public double calculate(String customerTypeStr, 
                           List<Double> prices, 
                           List<Integer> quantities, 
                           String discountCodeStr) {
        
        CustomerType customerType = CustomerType.fromString(customerTypeStr);
        DiscountCode discountCode = DiscountCode.fromString(discountCodeStr);
        
        double subtotal = subtotalCalculator.calculate(prices, quantities);
        double discount = discountCalculator.calculate(subtotal, customerType, discountCode);
        double tax = taxCalculator.calculate(subtotal);
        
        return subtotal - discount + tax;
    }
}
