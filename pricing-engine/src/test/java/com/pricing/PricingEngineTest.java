package test.java.com.pricing;

import java.util.*;

import com.pricing.PricingEngine;

class PricingEngineTest {
    @Test
    void testRegularCustomerNoDiscount() {
        PricingEngine engine = new PricingEngine();
        List<Double> prices = Arrays.asList(100.0, 50.0);
        List<Integer> qties = Arrays.asList(1, 2);
        double result = engine.calculate("REGULAR", prices, qties, "");
        // subtotal = 200, tax=40, disc=0 => 240
        assertEquals(240.0, result, 0.01);
    }

    private void assertEquals(double d, double result, double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    void testVipWithSave10() {
        PricingEngine engine = new PricingEngine();
        List<Double> prices = Arrays.asList(200.0);
        List<Integer> qties = Arrays.asList(1);
        double result = engine.calculate("VIP", prices, qties, "SAVE10");
        // sub=200, disc=20+10=30, tax=40 => 210
        assertEquals(210.0, result, 0.01);
    }
}