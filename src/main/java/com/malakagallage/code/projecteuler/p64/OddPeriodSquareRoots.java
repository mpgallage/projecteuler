package com.malakagallage.code.projecteuler.p64;

/**
 * @author : maal (Malaka Gallage)
 * @since : 27/11/17
 */
public class OddPeriodSquareRoots {
	
    public static void main(String[] args) {
    	
    	int count = 0;
    	for (int i = 1; i < 10000; i ++) {
    		
    		double sqrt = Math.sqrt(i);
    		
    		if (sqrt != (long)sqrt) {
    	    	
				if (expand(i, Math.floor(sqrt), 1, 0, 0) % 2 == 1) {
					count++;
				}
    		}
    	}
    	
    	System.out.println(count);
    }
    
    private static double expand(double x, double a, double b, double startA, double startB) {		// b/(Math.sqrt(x) - a)
    	
    	double decider = (x - a * a);
    	
    	if (decider <= 0 || x <= 1 || a <= 0 || b <= 0) {
    		return -1;
    	}
    	
    	double start = Math.ceil(a * b / decider);
    	double end = Math.floor(b / (Math.sqrt(x) - a));
    	
    	double nextA;
    	double nextB = decider / b;
    	
    	for (double i = start; i <= end; i++) {
    		
    		nextA = i * decider / b - a;
    		
    		if (startA != 0 && startB != 0 && startA == nextA && startB == nextB) {
    			return 0;
    		}
    		
        	if (startA == 0 || startB == 0) {
        		startA = nextA;
        		startB = nextB;
        	}
    		
    		double answer = expand(x, nextA, nextB, startA, startB);
    		if (answer >= 0) {
    			return 1 + answer;
    		}
    	}
    	
    	return -1;
	}
}
