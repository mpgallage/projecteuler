package com.malakagallage.code.projecteuler.p83;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : maal (Malaka Gallage)
 * @since : 11/04/18
 */
public class PathSumFourWays {

	private static final int LIMIT = 80;


	private static final long[][] inArr = new long[LIMIT + 1][LIMIT + 1];
	private static final long[][] outArr = new long[LIMIT + 1][LIMIT + 1];

	public static void main(String[] args) throws Exception {
    	
    	FileReader fr = new FileReader("src/main/resources/p083_matrix.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line;

        
        for (int i = 1; (line = br.readLine()) != null; i++) {
        	
        	int j = 1;
        	
        	String[] split = line.split(",");
        	
        	for (String s : split) {
        		
        		inArr[i][j] = Integer.parseInt(s);
        		
        		j++;
        	}
        }
        
        try {
        	fr.close();
        	br.close();
        } catch (Exception e) {
			// ignore
		}

        for (int i = 1; i <= LIMIT; i++) {
            for (int j = 0; j <= LIMIT; j++) {
                outArr[i][j] = Integer.MAX_VALUE;
            }
        }
        outArr[1][1] = inArr[1][1];

        propagate(1, 1, 0);

        System.out.println(outArr[LIMIT][LIMIT]);
	}

	private static void propagate(int i, int j, int direction) {


	    if (i != 1 && direction != 1) {
	        if (outArr[i][j] + inArr[i - 1][j] < outArr[i - 1][j]) {
                outArr[i - 1][j] = outArr[i][j] + inArr[i - 1][j];
                propagate(i -1, j, 2);
            }
        }

        if (i != LIMIT && direction != 2) {
            if (outArr[i][j] + inArr[i + 1][j] < outArr[i + 1][j]) {
                outArr[i + 1][j] = outArr[i][j] + inArr[i + 1][j];
                propagate(i + 1, j, 1);
            }
        }

        if (j != 1 && direction != 3) {
            if (outArr[i][j] + inArr[i][j - 1] < outArr[i][j - 1]) {
                outArr[i][j - 1] = outArr[i][j] + inArr[i][j - 1];
                propagate(i, j - 1, 4);
            }
        }

        if (j != LIMIT && direction != 4) {
            if (outArr[i][j] + inArr[i][j + 1] < outArr[i][j + 1]) {
                outArr[i][j + 1] = outArr[i][j] + inArr[i][j + 1];
                propagate(i, j + 1, 3);
            }
        }
    }

}
