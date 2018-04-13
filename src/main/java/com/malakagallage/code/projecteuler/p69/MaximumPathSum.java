package com.malakagallage.code.projecteuler.p69;

import com.malakagallage.code.projecteuler.util.EulerUtils;
/**
 * @author : maal (Malaka Gallage)
 * @since : 04/12/17
 */
public class MaximumPathSum {
	
    public static void main(String[] args) {
    	
    	double multiple = 1;
    	double prime = 2;
    	
    	while(true) {
    		
    		if (multiple > 1000000) {
    			break;
    		}
    		
    		multiple *= prime;
    		prime = EulerUtils.getNextPrime(prime);
    	}
    	
    	System.out.println(multiple);
    }
}

