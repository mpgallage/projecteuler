package com.malakagallage.code.projecteuler.p66;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;


import static com.malakagallage.code.projecteuler.util.EulerUtils.*;

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

                List<Double> list = expand(d);
                int l = list.size();

                list.add(Math.floor(sqrt));
                list.add(0d);

                if ((l - 1) % 2 == 0) {

                    list.remove(l-1);

                } else {

                    for (int i = 2; i <= l; i++) {
                        list.add(list.get(i));
                    }
                }

                BigInteger x = continuedFractionConvergence(list, Numeral.NUMERATOR);

                if (x.compareTo(max) == 1) {

                    max = x;
                    answer = d;
                }
            }
        }

        System.out.println(answer);
    }
}
