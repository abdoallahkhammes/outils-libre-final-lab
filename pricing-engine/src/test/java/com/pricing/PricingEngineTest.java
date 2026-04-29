package com.pricing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class PricingEngineTest {
    private PricingEngine engine;
    
    @BeforeEach
    void setUp() {
        engine = new PricingEngine();
    }
    
    @Test
    void testRegularCustomerNoDiscount() {
        List<Double> prices = Arrays.asList(100.0, 50.0);
        List<Integer> quantities = Arrays.asList(1, 2);
        double result = engine.calculate("REGULAR", prices, quantities, "");
        // Subtotal = 100 + 100 = 200, Tax = 40, Discount = 0
        assertEquals(240.0, result, 0.01);
    }
    
    @Test
    void testRegularCustomerWithSave10() {
        List<Double> prices = Arrays.asList(200.0);
        List<Integer> quantities = Arrays.asList(1);
        double result = engine.calculate("REGULAR", prices, quantities, "SAVE10");
        // Subtotal = 200, Discount = 20, Tax = 40
        assertEquals(220.0, result, 0.01);
    }
    
    @Test
    void testVipCustomerNoDiscount() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        double result = engine.calculate("VIP", prices, quantities, "");
        // Subtotal = 100, Discount = 5 (5% VIP), Tax = 20
        assertEquals(115.0, result, 0.01);
    }
    
    @Test
    void testVipCustomerWithSave20() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        double result = engine.calculate("VIP", prices, quantities, "SAVE20");
        // Subtotal = 100, Discount = 20 + 5 = 25, Tax = 20
        assertEquals(95.0, result, 0.01);
    }
}
