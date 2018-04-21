package com.malakagallage.code.projecteuler.p387;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 12/04/18
 */
public class HarshadNumbers {

    private static double primeSum = 0;
    private static long limit = 100_000_000_000_000l;

	public static void main(String[] args) {

        for (int i = 1; i <= 9 ; i++) {
            nextHarshad(i);
        }

        System.out.println(EulerUtils.doubleToString(primeSum));
    }

	private static void nextHarshad(long l) {

        int sum = 0;
        String s = "";

        char[] arr = String.valueOf(l).toCharArray();

        for (char c : arr) {
            sum += Long.valueOf(String.valueOf(c));
            s += c;
        }

        for (int i = 0; i <= 9; i++) {

            long m = Long.parseLong(s);
            long n = Long.parseLong(s + i);

            if (n >= limit) {
                break;
            }

            if (m % sum == 0) {

                if (EulerUtils.isPrime(m / sum) && EulerUtils.isPrime(n)) {
                    primeSum += n;
                }
                nextHarshad(n);
            }

        }
    }
}
