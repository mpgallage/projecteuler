package com.malakagallage.code.projecteuler.p75;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 025/04/18
 */
public class SingularIntegerRightTriangles {

	private static final int LIMIT = 1500000;
	private static final int[] counts = new int[LIMIT + 1];
    
	public static void main(String[] args) {

		int count = 0;
		
		for (int m = 2; m < Math.sqrt(LIMIT/2); m++) {
			
			for (int n = 1; n < m; n++) {
				
				if ((n + m) % 2 == 1 && EulerUtils.gcd(m, n) == 1) {
				
					int a = m*m - n*n;
					int b = 2*m*n;
					int c = m*m + n*n;
					
					int length = a + b + c;
					while (length <= LIMIT) {
						
						counts[length]++;
						length += a + b + c;
					}
				}
			}
		}
		
		for (int n : counts) {
			
			if (n == 1) {
				count++;
			}
		}
        
		System.out.println(count);
    }
}
