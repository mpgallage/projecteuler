package com.malakagallage.code.projecteuler.p66;

import java.math.BigDecimal;

/**
 * @author : maal (Malaka Gallage)
 * @since : 29/11/17
 */
public class DiophantineEquation {
	
    public static void main(String[] args) {

    	BigDecimal max = new BigDecimal(0);
    	long answer = 0;
    	
    	for (int d = 2; d <= 1000; d++) {

    		double sqrt = Math.sqrt(d);
            BigDecimal bigSQRT = new BigDecimal(String.valueOf(Math.ceil(sqrt)));
    		if (sqrt == (long) sqrt) {
    			continue;
    		}
    		
    		for (BigDecimal x = bigSQRT; true;) {
    			
    			double y = Math.sqrt(x.pow(2).subtract(BigDecimal.ONE).divide(new BigDecimal(d), 2, BigDecimal.ROUND_FLOOR).doubleValue());
    			
    			if ((long) y == y) {
    				System.out.println(x +"^2 - " + d + "*" + y + "^2 = 1");
    				
    				if (x.compareTo(max) == 1) {
    					max = x;
    					answer = (long) d;
    				}
    				break;
    			}

				if (x.compareTo(bigSQRT) == 0) {
					x = new BigDecimal(d - 1);
				} else if (x.add(BigDecimal.ONE).remainder(new BigDecimal(d)).compareTo(BigDecimal.ZERO) == 0) {
					x = x.add(new BigDecimal(2));
				} else {
					x = x.add(new BigDecimal(d - 2));
				}
			}
    	}
    	
    	System.out.println(answer);
	}
}
