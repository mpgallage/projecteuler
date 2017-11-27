package com.malakagallage.code.projecteuler.p58;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class SpiralPrimes {

    public static void main(String[] args) {

        double fullCount = 1;
        double primeCount = 0;

        for (long i = 3; true; i = i + 2) {

            fullCount += 4;

            if (EulerUtils.isPrime((i-1) * (i-1) + 1)) {
                primeCount++;
            }

            if (EulerUtils.isPrime(i * (i-1) + 1)) {
                primeCount++;
            }

            if (EulerUtils.isPrime(i * (i-3) + 3)) {
                primeCount ++;
            }

            if (primeCount/fullCount < 0.1) {
                System.out.println(i);
                break;
            }
        }
    }
}
