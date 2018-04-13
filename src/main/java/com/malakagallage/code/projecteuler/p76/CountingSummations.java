package com.malakagallage.code.projecteuler.p76;

/**
 * @author : maal (Malaka Gallage)
 * @since : 04/04/18
 */
public class CountingSummations {
	
	static int[] cache = new int[101];

    public static void main(String[] args) {
    	
    	cache[0] = 1;
    	
    	for (int i = 1; i <= 99; i++) {
    		for (int j = i; j <= 100; j++) {
    			cache[j] += cache[j - i];
    		}
    	}
    	
    	System.out.println(cache[100]);
    }
}
