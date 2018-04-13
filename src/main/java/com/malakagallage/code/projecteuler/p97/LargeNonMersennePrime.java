package com.malakagallage.code.projecteuler.p97;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class LargeNonMersennePrime {
	
	public static void main(String[] args) {
	
		long number = 28433;
		for (long i = 1; i <= 7830457; i++) {
			
			number *= 2;
			
			String s = String.valueOf(number);
			if (s.length() > 10) {
				String sub = s.substring(s.length() - 10, s.length());
				number = Long.parseLong(sub);
			}
		}
		
		System.out.println(number + 1);
	}
}
