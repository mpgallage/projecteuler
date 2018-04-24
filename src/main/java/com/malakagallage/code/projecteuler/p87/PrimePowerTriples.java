package com.malakagallage.code.projecteuler.p87;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/18
 */
public class PrimePowerTriples {
	
	private static final int LIMIT = 50000000;
	private static final boolean[] isPrime = new boolean[(int) Math.sqrt(LIMIT) + 1];
	private static final List<Integer> primes = new ArrayList<>();
	private static final Set<Double> set = new HashSet<>();

    public static void main(String[] args) {
    	
    	sieves(Math.sqrt(LIMIT));
    	
    	int p1;
    	for (int i = 0; (p1 = primes.get(i)) <= Math.sqrt(LIMIT); i++) {

    		int p2;
    		for (int j = 0; (p2 = primes.get(j)) <= Math.cbrt(LIMIT); j++) {
    			
    			if (p1*p1 + p2*p2*p2 > LIMIT) {
					break;
				}
    			
    			int p3;
    			for (int k = 0; (p3 = primes.get(k)) <= Math.abs(Math.pow(LIMIT, 0.25)); k++) {
    				
    				double num = p1*p1 + p2*p2*p2 + p3*p3*p3*p3;
    				
    				if (num > LIMIT) {
						break;
					}
    				
    				set.add(num);
    			}
    		}
		}
    	
    	System.out.println(set.size());
        
    }
    
    public static void sieves(double limit) {
    	
    	for (int i = 2; i <= limit; i++) {
			isPrime[i] = true;
		}
    	
    	for (int i = 2; i <= limit; i++) {
    		
    		if (!isPrime[i]) {
    			continue;
    		}
    		
    		for (int j = 2; i*j <= limit; j++) {
    			
				isPrime[i*j] = false;
    		}
    	}
    	
    	for (int i = 2; i <= limit; i++) {
    		if (isPrime[i]) primes.add(i);
    	}
    	primes.add(Integer.MAX_VALUE);
    }
}
