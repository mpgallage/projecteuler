package com.malakagallage.code.projecteuler.p57;

import java.math.BigInteger;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class SquareRootConvergence {

    private static BigInteger[] numerator = new BigInteger[1000];
    private static BigInteger[] denominator = new BigInteger[1000];

    static {
        numerator[0] = new BigInteger("1");
        denominator[0] = new BigInteger("1");
    }

    public static void main(String[] args) {

        int count = 0;
        BigInteger two = new BigInteger("2");

        for (int i = 1; i < 1000; i++) {

            numerator[i] = denominator[i-1].multiply(two).add(numerator[i-1]);
            denominator[i] = denominator[i-1].add(numerator[i-1]);


            if (String.valueOf(numerator[i]).length() > String.valueOf(denominator[i]).length()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
