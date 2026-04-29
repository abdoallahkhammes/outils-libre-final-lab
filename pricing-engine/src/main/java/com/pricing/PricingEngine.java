package com.pricing;

import java.util.*;

public class PricingEngine {
    public double calculate(String customerType, List<Double> prices, List<Integer> qties, String discountCode) {
        double sub = 0;
        for(int i=0;i<prices.size();i++) {
            sub = sub + prices.get(i) * qties.get(i);
        }
        double disc = 0;
        if(discountCode.equals("SAVE10")) disc = sub * 0.1;
        if(discountCode.equals("SAVE20")) disc = sub * 0.2;
        if(customerType.equals("VIP")) disc = disc + sub * 0.05;
        double tax = sub * 0.2;
        double fin = sub - disc + tax;
        return fin;
    }
}