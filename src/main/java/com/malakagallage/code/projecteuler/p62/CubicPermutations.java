package com.malakagallage.code.projecteuler.p62;

import static com.malakagallage.code.projecteuler.util.EulerUtils.*;

/**
 * @author : maal (Malaka Gallage)
 * @since : 26/11/17
 */
public class CubicPermutations {

    public static void main(String[] args) {

        for (int i = 1; i < 10000; i++) {

            int answer = checkCubes(i);
            if (answer == 5) {
                System.out.println(i + ", " + doubleToString(cube(i)));
                break;
            }
        }

    }

    public static int checkCubes(double n) {

        for (double i = n + 1; numberOfDigits(cube(i)) == numberOfDigits(cube(n)); i++) {

            if (isPermutation(cube(n), cube(i))) {
                return 1 + checkCubes(i);
            }
        }

        return 1;
    }

    static double cube(double n) {

        return n * n * n;
    }
}
