package com.malakagallage.code.projecteuler.p73;

import java.util.ArrayList;
import java.util.List;

import com.malakagallage.code.projecteuler.util.EulerUtils;


/**
 * @author : maal (Malaka Gallage)
 * @since : 04/04/18
 */
public class CountingFractionsInRange {
	
	private static final int LIMIT = 12000;
	
    public static void main(String[] args) {
    	
    	int sum = 0;
    	
    	for (double i = 5; i <= LIMIT; i++) {
			
    		double lower = Math.ceil(i/3);
    		double upper = i / 2;
    		
    		int increment = 1;
    		if (i % 2 == 0) {
    			if (lower % 2 == 0) {
    				lower++;
    			}
    			increment = 2;
    		}
    		
    		for (double j = lower; j < upper; j += increment) {
    			
    			if (EulerUtils.gcd(i, j) == 1) {
    				sum++;
    			}
    		}
		}
    	
    	System.out.println(sum);
        
    }
    
}
