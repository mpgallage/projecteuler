package com.malakagallage.code.projecteuler.p56;

import com.malakagallage.code.projecteuler.util.EulerUtils;

import java.math.BigInteger;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class PowerfulDigitSum {

    public static void main(String[] args) {

        long max = 0;
        long value;

        for (long i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {

                value = EulerUtils.digitSum(BigInteger.valueOf(i).pow(j));

                if (value > max) {
                    max = value;
                    System.out.println(i + " --- " + j + " --- " + value);
                }
            }
        }

        System.out.println(max);
    }

}
