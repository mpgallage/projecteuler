package com.malakagallage.code.projecteuler.p82;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : maal (Malaka Gallage)
 * @since : 11/04/18
 */
public class PathSumThreeWays {

	private static final int LIMIT = 5;


	private static final long[][] inArr = new long[LIMIT + 2][LIMIT + 1];
	private static final long[][] outArr = new long[LIMIT + 2][LIMIT + 1];

	public static void main(String[] args) throws Exception {

    	for (int i = 0; i <= LIMIT; i++) {
    		inArr[0][i] = Integer.MAX_VALUE;
			inArr[i][0] = Integer.MAX_VALUE;
			inArr[LIMIT + 1][i] = Integer.MAX_VALUE;

			outArr[0][i] = Integer.MAX_VALUE;
			outArr[i][0] = Integer.MAX_VALUE;
			outArr[LIMIT + 1][i] = Integer.MAX_VALUE;
    	}
    	
    	FileReader fr = new FileReader("src/main/resources/p082_matrix1.txt");
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
			outArr[i][1] = inArr[i][1];
		}

		for (int j = 2; j <= LIMIT; j++) {
			for (int i = 1; i <= LIMIT; i++) {

				long upDownMin = Math.min(minUP(i - 1, j), minDOWN(i + 1, j));
				outArr[i][j] = inArr[i][j] + Math.min(upDownMin, outArr[i][j - 1]);
    		}
		}

		long min = Long.MAX_VALUE;
        for (int i = 1; i < LIMIT; i++) {

			if (outArr[LIMIT][i] < min) {
				min = outArr[i][LIMIT];
			}
		}

		System.out.println(min);
	}

	private static long minUP(int i, int j) {

		if (i == 0) {
			return Long.MAX_VALUE;
		}

		long min = inArr[i][j] + outArr[i][j - 1];

		return Math.min(min, minUP(i - 1, j));
	}

	private static long minDOWN(int i, int j) {

		if (i == LIMIT + 1) {
			return Long.MAX_VALUE;
		}

		long min = inArr[i][j] + outArr[i][j - 1];

		return Math.min(min, minDOWN(i + 1, j));
	}
}
