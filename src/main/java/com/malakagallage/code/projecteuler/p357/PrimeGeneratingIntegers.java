package com.malakagallage.code.projecteuler.p357;

/**
 * @author : maal (Malaka Gallage)
 * @since : 12/04/18
 */
public class PrimeGeneratingIntegers {
	static int limit = 100_000_000;
	static boolean[] primePos = new boolean[limit + 1];
	
	public static void main(String[] args) {
	
		long sum = 0;
		populate(limit);
		
		for (int i = 2; i < limit; i++) {
			
			int n = i - 1;
			
			if (primePos[i] && isPGI(n)) {
				sum += n;
			}
		}
		System.out.println(sum);
		
	}
	
	private static void populate(int n) {
		
		primePos[2] = true;
		for (int i = 3; i <= n; i += 2) {
			primePos[i] = true;
		}
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			
			if (!primePos[i]) {
				continue;
			}

			int multiple = i * 2;
			for (int j = 3; multiple <= n; j++) {
				
				primePos[multiple] = false;
				multiple = i * j;
			}
			
		}
	}
	
	private static boolean isPGI(int n) { // is prime generating integers
		
		for (int i = 1; i <= Math.sqrt(n); i++) {
			
			if (n % i == 0) {
				
				if (!primePos[i + n/i]) {
					return false;
				}
			}
		}
		return true;
	}
}
