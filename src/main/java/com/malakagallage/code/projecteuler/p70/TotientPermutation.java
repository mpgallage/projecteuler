package com.malakagallage.code.projecteuler.p70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.malakagallage.code.projecteuler.util.EulerUtils;
/**
 * @author : maal (Malaka Gallage)
 * @since : 04/12/17
 */
public class TotientPermutation {
	
	private static final int LIMIT = 10000000;
	private static final int[] cache = new int[LIMIT + 1];
	private static final List<Integer> primes = new ArrayList<>();
	
    public static void main(String[] args) {
    	
    	init();
    	
    	double minRatio = Double.MAX_VALUE;
    	double answer = 0;
    	
    	for (int i = 0; primes.get(i) <= LIMIT/2; i++) {
    		
    		for (int j = 0; primes.get(j) <= LIMIT/2; j++) {
				
    			double x = primes.get(i) * primes.get(j);
    			
    			if (x > LIMIT) {
    				break;
    			}
    			
    			double phi = (primes.get(i) - 1) * (primes.get(j) - 1);
    			double ratio = x / phi;
    			
    			if (ratio < minRatio && isPermutation(x, phi)) {
    				minRatio = ratio;
    				answer = x;
    			}
			}
    	}   
    	System.out.println(answer);
    }
    
    public static void init() {
    	
    	for (int i = 1; i <= LIMIT; i++) {
			cache[i] = i;
		}
    	
    	sieves();
    }
    
    public static void sieves() {
    	for (int i = 2; i <= LIMIT; i++) {
    		
    		if (cache[i] != i) {
    			continue;
    		}
    		
    		for (int j = 1; i*j <= LIMIT; j++) {
    			
				cache[i*j] = i;
    		}
    	}
    	
    	for (int i = 2; i <= LIMIT; i++) {
    		if (cache[i] == i) primes.add(i);
    	}
    }
    
    public static boolean isPermutation(double x, double y) {
    	
    	char[] xArr = EulerUtils.doubleToString(x).toCharArray();
		char[] yArr = EulerUtils.doubleToString(y).toCharArray();

    	if (xArr.length == yArr.length) {
    		
    		Arrays.sort(xArr);
    		Arrays.sort(yArr);
    		
    		x = Double.parseDouble(new String(xArr));
    		y = Double.parseDouble(new String(yArr));
    		
    		if (x == y) {
    			return true;
    		}
    	}
    	
    	return false;
    }
}

