package com.malakagallage.code.projecteuler.p65;

import java.math.BigInteger;
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
    	
    	BigInteger[] a = new BigInteger[101];
    	BigInteger[] x = new BigInteger[101];
    	BigInteger[] y = new BigInteger[101];
    	
    	a[1] = new BigInteger("2");
    	
    	for (int i = 2, j = 1; i < 101; i++) {
    	
			a[i] = i  % 3 == 0 ? new BigInteger(String.valueOf(i * 2 / 3)) : new BigInteger("1");
		}
    	
    	
    	x[100] = a[100];
    	y[100] = new BigInteger("1");
    	
    	for (int i = 99; i > 0; i--) {
        	
			x[i] = x[i + 1].multiply(new BigInteger(String.valueOf(a[i]))).add(y[i+1]);
			y[i] = x[i + 1];
		}
    	
    	String[] arr = x[1].toString().split("");
    	int sum = Arrays.stream(arr).mapToInt(Integer::parseInt).sum();

    	System.out.println(sum);
	}
}
