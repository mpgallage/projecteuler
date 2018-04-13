package com.malakagallage.code.projecteuler.p206;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class ConcealedSquare {
	
	public static void main(String[] args) {
	
		for (long l = 1058921220; l <= 1389026623; l++) {
			
			long square = l * l;
			char[] arr = String.valueOf(square).toCharArray();
			int i = 1;
			for (; i <= 10; i++) {
				if (Integer.parseInt(String.valueOf(arr[2 * (i - 1)])) != i) {
					break;
				}
			}
			if (i == 10 && arr[arr.length - 1] == '0') {
				System.out.println(l);
				System.out.println(square);
			}
		}
	}
}
