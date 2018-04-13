package com.malakagallage.code.projecteuler.p71;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 04/04/18
 */
public class OrderedFractions {
	
    public static void main(String[] args) {
    	
    	double x = 3;
    	double y = 7;
    	double xx = 3;
    	double yy = 7;
    	
    	double answer = 0;
    	
    	double max = 0;
    	
    	double limit = 3d/7d;
    	
    	for (double i = 2; yy <= 1000000; i++, xx = i * x, yy = i * y) {
    		
    		double val = (xx - 1) / yy;
    		
    		if (val > max && val < limit && EulerUtils.gcd((xx - 1), yy) == 1) {
    			max = val;
    			answer = xx - 1;
    		}
    	}
    	
    	System.out.println(answer);
        
    }
}
