package com.malakagallage.code.projecteuler.p66;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.malakagallage.code.projecteuler.util.EulerUtils.doubleToString;

/**
 * @author : maal (Malaka Gallage)
 * @since : 29/11/17
 */
public class DiophantineEquation {
	
    public static void main(String[] args) {

        int answer = 0;
        BigInteger max = BigInteger.ZERO;

        for (int d = 2; d <= 1000; d ++) {

            double sqrt = Math.sqrt(d);

            if (sqrt != (long)sqrt) {

                List<Double> list = expand(d, Math.floor(sqrt), 1, 0, 0);
                int l = list.size();

                list.add(Math.floor(sqrt));
                list.add(0d);

                if (l % 2 == 0) {

                    list.remove(0);
                    Collections.reverse(list);

                } else {

                    Collections.reverse(list);
                    for (int i = 2; i <= l; i++) {
                        list.add(list.get(i));
                    }
                }

                int size = list.size();
                BigInteger[] x = new BigInteger[size];
                BigInteger[] y = new BigInteger[size];

                x[size - 1] = new BigInteger(doubleToString(list.get(size - 1)));
                y[size - 1] = BigInteger.ONE;

                for (int i = size - 2; i > 0; i--) {

                    x[i] = x[i + 1].multiply(new BigInteger(doubleToString(list.get(i)))).add(y[i + 1]);
                    y[i] = x[i + 1];
                }

                if (x[1].compareTo(max) == 1) {

                    max = x[1];
                    answer = d;
                }
            }
        }

        System.out.println(answer);
    }

    private static List<Double> expand(double x, double a, double b, double startA, double startB) {		// b/(Math.sqrt(x) - a)

        double decider = (x - a * a);

        if (decider <= 0 || x <= 1 || a <= 0 || b <= 0) {
            return null;
        }

        double start = Math.ceil(a * b / decider);
        double end = Math.floor(b / (Math.sqrt(x) - a));

        double nextA;
        double nextB = decider / b;

        for (double i = start; i <= end; i++) {

            nextA = i * decider / b - a;

            if (startA != 0 && startB != 0 && startA == nextA && startB == nextB) {
                return new ArrayList<>();
            }

            if (startA == 0 || startB == 0) {
                startA = nextA;
                startB = nextB;
            }

            List<Double> list = expand(x, nextA, nextB, startA, startB);
            if (list != null) {
                list.add(i);
                return list;
            }
        }

        return null;
    }
}
