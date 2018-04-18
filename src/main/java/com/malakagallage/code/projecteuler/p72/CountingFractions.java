package com.malakagallage.code.projecteuler.p72;

import com.malakagallage.code.projecteuler.util.EulerUtils;


/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/18
 */
public class CountingFractions {
	
	private static final int LIMIT = 8;
	
    public static void main(String[] args) {
    	
    	int sum = 0;
    	
    	for (double i = 2; i <= LIMIT; i++) {
			
    		int increment = 1;
    		if (i % 2 == 0) {
    			increment = 2;
    		}
    		
    		for (double j = 1; j < i; j += increment) {
    			
    			if (EulerUtils.gcd(i, j) == 1) {
    				sum++;
    			}
    		}
		}
    	
    	System.out.println(sum);
        
    }
    
}
