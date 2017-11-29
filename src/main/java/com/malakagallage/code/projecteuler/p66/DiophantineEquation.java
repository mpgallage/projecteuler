package com.malakagallage.code.projecteuler.p66;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 27/11/17
 */
public class DiophantineEquation {
	
    public static void main(String[] args) {
    	

    	double max = 0;
    	long answer = 0;
    	
    	for (double d = 2; d <= 1000; d++) {
    		
    		double sqrt = Math.sqrt(d);
    		if (sqrt == (long) sqrt) {
    			continue;
    		}
    		
    		for (double x = Math.floor(sqrt); true; x++) {
    			
    			double y = Math.sqrt((x * x - 1) / d);
    			
    			if ((long) y == y) {
    				System.out.println(x +"^2 - " + d + "*" + y + "^2 = 1");
    				
    				if (x > max) {
    					max = x;
    					answer = (long) d;
    				}
    				break;
    			}
    		}
    	}
    	
    	System.out.println(answer);
	}
}
