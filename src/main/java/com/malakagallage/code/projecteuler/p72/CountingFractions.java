package com.malakagallage.code.projecteuler.p72;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/18
 */
public class CountingFractions {
	
	private static final int LIMIT = 1000000;
	private static final boolean[] isPrime = new boolean[LIMIT + 1];
	private static final List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
    	
    	long sum = 0;
    	sieves();
    	
    	for (int i = 2; i <= LIMIT; i++) {
			
    		int totient = phi(i);
    		sum += totient;
		}
    	
    	System.out.println(sum);
        
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
    
    public static Map <Integer, Integer> primeFactors(int n, Map<Integer, Integer> map) {
    	
    	if (map == null) {
    		map = new HashMap<>();
    	}
    	
    	if (isPrime[n]) {
    		return incrementInMap(map, n);
    	}
    	
    	int p = 0;
    	int d = 0;
    	for (int i = 0; (p = primes.get(i)) <= Math.sqrt(n); i++) {
			
    		if (n % p == 0) {
    			
    			map = incrementInMap(map, p);
    			d = n / p;
    			
    			if (isPrime[d]) {
    				return incrementInMap(map, d);
    			}
    			break;
    		}
		}
		return primeFactors(d, map);
    }
    
    public static Map<Integer, Integer> incrementInMap(Map<Integer, Integer> map, int p) {
    	
    	if (map.get(p) == null) {
    		map.put(p, 0);
    	}
    	map.put(p, map.get(p) + 1);
    	
    	return map;
    }
    
    //Euler totient
    private static int phi(int n) {
    	
    	Map<Integer, Integer> factors =  primeFactors(n, new HashMap<>());
    	
    	int totient = 1;
    	for (int x : factors.keySet()) {
			
    		int r = factors.get(x);
    		
    		totient *= Math.pow(x, r - 1) * (x - 1);
		}
    	
    	return totient;
    }
}
