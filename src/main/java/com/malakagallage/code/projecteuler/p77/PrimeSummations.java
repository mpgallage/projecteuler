package com.malakagallage.code.projecteuler.p77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : maal (Malaka Gallage)
 * @since : 04/04/18
 */
public class PrimeSummations {
	
	private static final int LIMIT = 100;
	private static final boolean[] isPrime = new boolean[LIMIT + 1];
	private static final List<Integer> primes = new ArrayList<>();
	static int[] cache = new int[LIMIT + 1];

    public static void main(String[] args) {
    	
    	sieves();
    	
    	cache[0] = 1;
    	cache[1] = 0;
    	
    	for (int p : primes) {
    		
    		for (int i = p; i <= LIMIT; i++) {
    			
    			cache[i] += cache[i - p];
    		}
    	}
    	
    	for (int i = 2; i <= LIMIT; i++) {
			
    		if (cache[i] > 5000) {
    			System.out.println(i);
    			break;
    		}
		}
    }
    
    public static void sieves() {
    	
    	for (int i = 2; i <= LIMIT; i++) {
			isPrime[i] = true;
		}
    	
    	for (int i = 2; i <= LIMIT; i++) {
    		
    		if (!isPrime[i]) {
    			continue;
    		}
    		
    		for (int j = 2; i*j <= LIMIT; j++) {
    			
				isPrime[i*j] = false;
    		}
    	}
    	
    	for (int i = 2; i <= LIMIT; i++) {
    		if (isPrime[i]) primes.add(i);
    	}
    }
}
