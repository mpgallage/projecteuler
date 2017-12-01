package com.malakagallage.code.projecteuler.p65;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.malakagallage.code.projecteuler.util.EulerUtils;
import com.malakagallage.code.projecteuler.util.EulerUtils.Numeral;

/**
 * @author : maal (Malaka Gallage)
 * @since : 27/11/17
 */
public class ConvergentsOfE {
	
    public static void main(String[] args) {
    	
    	List<Double> a = new ArrayList<>();
    	a.add(2d);
    	
    	for (double i = 1, j = 1; i < 100; i++) {
    	
			a.add((i + 1)  % 3 == 0 ? (i + 1) * 2 / 3 : 1d);
		}
    	
    	System.out.println(a.toString());
    	
    	BigInteger x = EulerUtils.continuedFractionConvergence(a, Numeral.NUMERATOR);
    	
    	String[] arr = x.toString().split("");
    	int sum = Arrays.stream(arr).mapToInt(Integer::parseInt).sum();

    	System.out.println(sum);
	}
}
