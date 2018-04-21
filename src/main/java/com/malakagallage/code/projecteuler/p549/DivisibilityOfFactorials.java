package com.malakagallage.code.projecteuler.p549;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @author : maal (Malaka Gallage)
 * @since : 12/04/18
 */
public class DivisibilityOfFactorials {

    public static final int limit = (int) Math.pow(10, 8);

    static int[] greatestPrimeFactors;

    static {
        greatestPrimeFactors = IntStream.range(0, limit + 1).toArray();

        for (int i = 2; i <= Math.sqrt(limit); i++) {

            if (greatestPrimeFactors[i] != i) {
                continue;
            }

            for (int j = 2; i * j < limit + 1; j++) {
                greatestPrimeFactors[i * j] = i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(S(limit));

    }

    public static long S(int n) {

        long answer = 0;
        for (int i = 2; i <= n; i++) {
            answer += s(i);
        }
        return answer;
    }

    public static long s(int n) {

        ArrayList<Integer> factors = factorize(n);

        long answer = 0;

        for (int i = 0; i < factors.size(); i++) {

            int lastIndex = factors.lastIndexOf(factors.get(i));
            int exponent = lastIndex - i + 1;

            answer = Math.max(answer, factors.get(i) * r(exponent, factors.get(i)));

            i = lastIndex;
        }
        return answer;
    }

    private static ArrayList<Integer> factorize(int n) {

        ArrayList<Integer> factors = new ArrayList<>();

        while (n != 1) {

            int largestPrime = greatestPrimeFactors[n];

            while (n % largestPrime == 0) {

                factors.add(largestPrime);
                n /= largestPrime;
            }
        }
        return factors;
    }

    private static int r(int exponent, int prime) {

        int k = exponent;

        k = (k * prime - 1) / (prime + 1);

        while (f(k, prime) >= exponent) {
            k--;
        }
        return k + 1;
    }

    private static int f(int j, int prime) {

        int k = j == 0 ? 0 : f(j / prime, prime) + j;
        return k;
    }
}
