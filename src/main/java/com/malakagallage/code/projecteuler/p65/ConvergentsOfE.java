package com.malakagallage.code.projecteuler.p65;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 27/11/17
 */
public class ConvergentsOfE {
	
    public static void main(String[] args) {
    	
    	double[] a = new double[101];
    	double[] x = new double[101];
    	double[] y = new double[101];
    	
    	a[1] = 2;
    	
    	for (int i = 2, j = 1; i < 101; i++) {
    	
			a[i] = i  % 3 == 0 ? i * 2 / 3 : 1;
		}
    	
    	
    	x[100] = a[100];
    	y[100] = 1;
    	
    	for (int i = 99; i > 0; i--) {
        	
			x[i] = x[i + 1] * a[i] + y[i+1];
			y[i] = x[i + 1];
		}
    	
    	
    	String[] arr = EulerUtils.doubleToString(x[1]).split("");
    	int sum = Arrays.stream(arr).mapToInt(Integer::parseInt).sum();
    	
    	System.out.println(x[1]);
    	System.out.println(sum);
	}
}
