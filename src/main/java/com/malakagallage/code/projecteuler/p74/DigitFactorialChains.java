package com.malakagallage.code.projecteuler.p74;


import java.util.*;

/**
 * @author : maal (Malaka Gallage)
 * @since : 04/04/18
 */
public class DigitFactorialChains {

	static int[] factorials = new int[10];

    static  {

        factorials[0] = 1;
        int num = 1;
        for (int i = 1; i < 10; i++) {
            num *= i;
            factorials[i] = num;
        }
    }

    public static void main(String[] args) {

        List<Integer> list;
        int count = 0;
        for (int n = 11; n < 1000000; n++) {

            list = new ArrayList<>();
            list.add(n);
            if (loop(n, list) == 60) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int digitFactorialSum(int n) {

        char[] arr = String.valueOf(n).toCharArray();
        int sum = 0;

        for (char c : arr) {
            sum += factorials[Character.getNumericValue(c)];
        }

        return sum;
    }

    private static int loop(int n, List<Integer> list) {

        int x = digitFactorialSum(n);

        if (list.contains(x)) {

            return list.size();

        } else {
            list.add(x);
            return loop(x, list);
        }
    }
}
