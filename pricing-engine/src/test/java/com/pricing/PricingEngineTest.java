package com.pricing;

import com.pricing.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pricing Engine Tests")
class PricingEngineTest {
    private PricingEngine engine;
    
    @BeforeEach
    void setUp() {
        engine = new PricingEngine();
    }
    
    @Test
    @DisplayName("Regular customer with no discount")
    void testRegularCustomerNoDiscount() {
        List<Double> prices = Arrays.asList(100.0, 50.0);
        List<Integer> quantities = Arrays.asList(1, 2);
        double result = engine.calculate("REGULAR", prices, quantities, "");
        assertEquals(240.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Regular customer with SAVE10")
    void testRegularCustomerWithSave10() {
        List<Double> prices = Arrays.asList(200.0);
        List<Integer> quantities = Arrays.asList(1);
        double result = engine.calculate("REGULAR", prices, quantities, "SAVE10");
        assertEquals(220.0, result, 0.01);
    }
    
    @Test
    @DisplayName("VIP customer with no discount")
    void testVipCustomerNoDiscount() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        double result = engine.calculate("VIP", prices, quantities, "");
        assertEquals(115.0, result, 0.01);
    }
    
    @Test
    @DisplayName("VIP customer with SAVE20")
    void testVipCustomerWithSave20() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        double result = engine.calculate("VIP", prices, quantities, "SAVE20");
        assertEquals(95.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Invalid discount code defaults to none")
    void testInvalidDiscountCode() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        double result = engine.calculate("REGULAR", prices, quantities, "INVALID_CODE");
        assertEquals(120.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Multiple items with VIP and discount")
    void testMultipleItemsVipWithDiscount() {
        List<Double> prices = Arrays.asList(50.0, 30.0, 20.0);
        List<Integer> quantities = Arrays.asList(2, 1, 3);
        // Subtotal: 100 + 30 + 60 = 190
        // Discount SAVE10: 19, VIP extra: 9.5, Total discount: 28.5
        // Tax: 38
        // Final: 190 - 28.5 + 38 = 199.5
        double result = engine.calculate("VIP", prices, quantities, "SAVE10");
        assertEquals(199.5, result, 0.01);
    }
}
