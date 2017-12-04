package com.malakagallage.code.projecteuler.p67;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author : maal (Malaka Gallage)
 * @since : 04/12/17
 */
public class MaximumPathSum {
	
    public static void main(String[] args) throws IOException {

    	int [][] arr = new int[100][100];
    	
    	FileReader fr = new FileReader("src/main/resources/p067_triangle.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int n = 0;
        
        while ((line = br.readLine()) != null) {
        	
        	String[] split = line.split("\\s");
        	
        	for (int i = 0; i < split.length; i++) {
        		
        		arr[n][i] = Integer.parseInt(split[i]);
        	}
        	
        	n++;
        }
        
        br.close();
        fr.close();
        
        for (int i = 99; i > 0; i--) {
        	
        	for (int j = i; j > 0; j--) {
        		
        		arr[i-1][j-1] = arr[i-1][j-1] + (arr[i][j] > arr[i][j-1] ? arr[i][j] : arr[i][j-1]);
        	}
        }
        
        System.out.println(arr[0][0]);
    }
}
