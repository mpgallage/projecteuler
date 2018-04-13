package com.malakagallage.code.projecteuler.p92;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class SquareDigitChains {
	
	static int[] cache = new int[10000000];

	public static void main(String[] args) {
	
		int sum = 0;
	   for (int i = 2; i < 10000000; i ++) {
		   
		   if (calculate(i)) {
			   sum++;
		   }
	   }
	   
	   System.out.println(sum);
	}
	
	private static boolean calculate(int i) {
		
		int answer = 0;
		if (cache[i] != 0) {
			answer =  cache[i];
		}
		
		if (answer == 0) {
			String[] arr = String.valueOf(i).split("");
			
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				
				int val = Integer.parseInt(arr[j]);
				sum += (val * val);
			}
			answer = sum;
		}
		

		cache[i] = answer;

		if (answer == 89) {
			return true;
			
		} else if (answer == 1) {
			return false;
		}
		
		return calculate(answer);
	}
}
