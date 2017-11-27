package com.malakagallage.code.projecteuler.p60;

import java.util.List;

import static com.malakagallage.code.projecteuler.util.EulerUtils.*;

/**
 * @author : maal (Malaka Gallage)
 * @since : 25/11/17
 */
public class PrimePairSets {

    private static List<Double> primes;

    public static void main(String[] args) {

        primes = populatePrimes(10000);
        boolean finish = false;

        for (int i = 0; i < primes.size(); i++) {

            for (int j = i-1; j > 0; j--) {

                if (isPrimeConcat(i, j) && isPrimeConcat(j, i)) {

                    for (int k = j-1; k > 0; k--) {

                        if (isPrimeConcat(i, k) && isPrimeConcat(k, i)
                                && isPrimeConcat(k, j) && isPrimeConcat(j, k)) {

                            for (int l = k-1; l > 0; l--) {

                                if (isPrimeConcat(i, l) && isPrimeConcat(l, i)
                                        && isPrimeConcat(l, j) && isPrimeConcat(j, l)
                                        && isPrimeConcat(k, l) && isPrimeConcat(l, k)) {

                                    for (int m = l-1; m > 0; m--) {

                                        if (isPrimeConcat(i, m) && isPrimeConcat(m, i)
                                                && isPrimeConcat(m, j) && isPrimeConcat(j, m)
                                                && isPrimeConcat(k, m) && isPrimeConcat(m, k)
                                                && isPrimeConcat(m, l) && isPrimeConcat(l, m)) {

                                            double sum = primes.get(i) + primes.get(j) + primes.get(k) + primes.get(l) + primes.get(m);
                                            System.out.println(primes.get(i) + " + " + primes.get(j) + " + " + primes.get(k) + " + "
                                                    + primes.get(l) + " + " + primes.get(m) + " = " + sum);
                                            finish = true;
                                            break;
                                        }
                                    }
                                }
                                if (finish) {
                                    break;
                                }
                            }
                        }
                        if (finish) {
                            break;
                        }
                    }
                }
                if (finish) {
                    break;
                }
            }
            if (finish) {
                break;
            }
        }
    }

    private static boolean isPrimeConcat(int a, int b) {

        return isPrime(concatenateDouble(primes.get(a), primes.get(b)));
    }
}
