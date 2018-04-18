package com.malakagallage.code.projecteuler.p112;
/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/17
 */
public class BouncyNumbers {
	
	public static void main(String[] args) throws Exception {
		
		double bouncyCount = 0;
		double percentage = 0;
		
		for (double i = 1; ; i++) {
			
			if (isBouncy((long)i)) bouncyCount++;
			
			percentage = bouncyCount*100/i;
			
			if (percentage == 99) {
				System.out.println(i);
				break;
			}
		}
	}
	
	private static boolean isBouncy(long l) {
		
		char[] arr = String.valueOf(l).toCharArray();
		
		int order = 0;
		
		for (int i = 0; i < arr.length - 1; i++) {
			
			if ((arr[i] < arr[i+1] && order == -1) || (arr[i] > arr[i+1] && order == 1)) {
				return true;
			}
			
			if (arr[i] < arr[i+1]) {
				order = 1;
			}
			if (arr[i] > arr[i+1]) {
				order = -1;
			}
		}
		
		return false;
	}
}
