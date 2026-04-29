package com.pricing;

import java.util.List;

public class SubtotalCalculator {
    public double calculate(List<Double> prices, List<Integer> quantities) {
        if (prices == null || quantities == null || prices.size() != quantities.size()) {
            throw new IllegalArgumentException("Prices and quantities must be non-null and same size");
        }
        
        double subtotal = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }
        return subtotal;
    }
}
