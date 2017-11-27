package com.malakagallage.code.projecteuler.p63;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 26/11/17
 */
public class PowerfulDigitCounts {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; true; j++) {

                double answer = Math.pow(i, j);
                int length = EulerUtils.doubleToString(answer).length();

                if (length == j) {
                    count++;

                } else if (length < j) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
