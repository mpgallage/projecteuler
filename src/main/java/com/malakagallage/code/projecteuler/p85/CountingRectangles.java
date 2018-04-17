package com.malakagallage.code.projecteuler.p85;

/**
 * @author : maal (Malaka Gallage)
 * @since : 11/04/18
 */
public class CountingRectangles {
	
	private static final int[] sigma = new int[2400];
	private static final int LIMIT = 2000000;
	private static int MIN_DIFF = Integer.MAX_VALUE;
	
	static {
		sigma[0] = 0;
		for (int i = 1; i < sigma.length; i++) {
			sigma[i] = i + sigma[i-1];
		}
	}
	
    public static void main(String[] args) throws Exception {
    	
    	int answer = 0;
    	int startCount = 0;
    	boolean end = true;
    	
		for (int x = 1; end; x++) {
    		
	    	int count = 0;

    		for (int y = x; count <= LIMIT; y++) {
				
    			if (x == y) {
    				count = startCount + x * sigma[x];
    			} else {
    				count += y * sigma[x];
    			}
    			
    			if (MIN_DIFF >= Math.abs(LIMIT - count)) {
        			MIN_DIFF = Math.abs(count - LIMIT);
        			answer =  x * y;
    				//System.out.println(x + " x " + y + " = " + x * y + " ===> "+ count);
    			}
    			
    			if (x + 1 == y) {
    				startCount = count;
    			}
    			if (x == y && count > LIMIT) {
        			end = false;
        		}
			}
    	}
		System.out.println(answer);
    }
}
