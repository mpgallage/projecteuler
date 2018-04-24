package com.malakagallage.code.projecteuler.p80;

import java.math.BigDecimal;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/18
 */
public class SquareRootDigitalExpansion {

    public static void main(String[] args) {
    	        
    	int sum = 0;
    	for (int i = 2; i < 100; i++) {
    		
    		double sqrt = Math.sqrt(i);
    		if (sqrt == (int) sqrt) continue;
    		
    		BigDecimal x = EulerUtils.sqrtNewtonRaphson(new BigDecimal(i));
    		
    		sum += decimalSum(x);
    	}
    	
    	System.out.println(sum);
    }
    
    private static int decimalSum(BigDecimal n) {
    	
    	String[] split = n.toString().split("\\.");
    	String s = split[1].substring(0, 99);
    	
    	int sum = 0;
    	for (char c : s.toCharArray()) {
    		
    		sum += Character.getNumericValue(c);
    	}
    	
    	return sum + Integer.parseInt(split[0]);
    }
}
