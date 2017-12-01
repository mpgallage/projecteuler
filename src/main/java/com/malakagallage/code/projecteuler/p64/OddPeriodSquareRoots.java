package com.malakagallage.code.projecteuler.p64;

import java.util.List;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 27/11/17
 */
public class OddPeriodSquareRoots {
	
    public static void main(String[] args) {
    	
    	int count = 0;
    	for (int i = 1; i < 10000; i ++) {
    		
    		double sqrt = Math.sqrt(i);
    		
    		if (sqrt != (long)sqrt) {
    	    	
    			List<Double> list = EulerUtils.expand(i);
				if (list != null && list.size() % 2 == 0) {
					count++;
				}
    		}
    	}
    	
    	System.out.println(count);
    }
    
}
