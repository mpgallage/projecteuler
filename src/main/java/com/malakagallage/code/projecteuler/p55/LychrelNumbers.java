package com.malakagallage.code.projecteuler.p55;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class LychrelNumbers {
	
	public static void main(String[] args) {
		
		int count = 0;

		for (int i = 1; i <= 10000; i++) {

			if (findLychrel(new Number(i)) == null) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	private static Number findLychrel(Number num) {

		double sum = 0;
        sum = num.getValue() + EulerUtils.reverse(num.getValue());
		
		if (EulerUtils.isPalindromic(sum)) {
			return num;
		}
		
		if (num.getIteration() == 50) {
			return null;
		}
		
		num.setValue(sum);
		num.increseItr();
		
		return findLychrel(num);
	}

}
