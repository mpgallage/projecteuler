package com.malakagallage.code.projecteuler.p81;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : maal (Malaka Gallage)
 * @since : 11/04/18
 */
public class PathSumTwoWays {
	
    public static void main(String[] args) throws Exception {
    	
    	long[][] arr = new long[81][81];
    	
    	for (int i = 0; i < 81; i++) {
    		arr[0][i] = Integer.MAX_VALUE;
    		arr[i][0] = Integer.MAX_VALUE;
    	}
    	
    	FileReader fr = new FileReader("src/main/resources/p081_matrix.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line;
        int i = 1;
        
        while ((line = br.readLine()) != null) {
        	
        	int j = 1;
        	
        	String[] split = line.split(",");
        	
        	for (String s : split) {
        		
        		arr[i][j] = Integer.parseInt(s);
        		
        		j++;
        	}
        	i++;
        }
        
        try {
        	fr.close();
        	br.close();
        } catch (Exception e) {
			// ignore
		}
        
        for (i = 1; i <= 80; i++) {
        	
        	for (int j = 1; j <= 80; j++) {
        		
        		if (i == 1 && j == 1) {
        			continue;
        		}
    			
        		arr[i][j] += arr[i-1][j] < arr[i][j-1] ? arr[i-1][j] : arr[i][j-1];
    		}
		}
        
        System.out.println(arr[80][80]);
    }
}
