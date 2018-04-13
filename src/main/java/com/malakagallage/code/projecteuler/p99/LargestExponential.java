package com.malakagallage.code.projecteuler.p99;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class LargestExponential {
	
	public static void main(String[] args) throws Exception {
	
		double[][] arr = new double[1001][2];
		double[] cache;
		
		int maxLine = 0;
    	
    	FileReader fr = new FileReader("src/main/resources/p099_base_exp.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line;
        int i = 1;
        
        while ((line = br.readLine()) != null) {
        	
        	String[] split = line.split(",");
    		arr[i][0] = Double.parseDouble(split[0]);
    		arr[i][1] = Double.parseDouble(split[1]);
        	i++;
        }
        
        try {
        	fr.close();
        	br.close();
        } catch (Exception e) {
			// ignore
		}
        
        cache = arr[1];
        
        double a = cache[0];
        double b = cache[1];
        
        for (int j = 2; j <= 1000; j++) {
        	
        	double x = arr[j][0];
        	double y = arr[j][1];
        	
        	if (x >= a && y >= b) {
        		a = x;
        		b = y;
        		maxLine = j;
        		continue;
        	}
        	
        	if (x < a && y < b) {
        		continue;
        	}
        	
        	double val = y * Math.log(x) - b * Math.log(a);
        	
        	if (val > 0) {
        		a = x;
        		b= y;
        		maxLine = j;
        	}
		}
        
        System.out.println(maxLine);
	}
}
