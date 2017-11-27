package com.malakagallage.code.projecteuler.p61;

import java.util.Arrays;

/**
 * @author : maal (Malaka Gallage)
 * @since : 25/11/17
 */
public class CyclicalFigurateNumbers {

    static boolean[][] matrix = new boolean[6][10000];

    static Number[] objects = new Number[6];

    static int startingIndex = 0;

    public static void main(String[] args) {

        fillMatrix();

        for (int i = 0; i < 6; i++) {

            int j = 1;
            int num;

            while (true) {

                int[] answers = new int[6];

                if (matrix[i][j]) {
                    num = objects[i].calculate(j);

                    if (num > 10000) {
                        break;
                    }

                    startingIndex = i;
                    searchNext(num, i, answers);

                }

                j++;
            }
        }
    }

    private static void fillMatrix() {

        for (int i = 0; i < 6; i++) {

            switch (i) {

                case 0: // triangular
                    objects[i] = (int n) -> n * (n + 1) / 2;
                    break;

                case 1: // square
                    objects[i] = (int n) -> n * n;
                    break;

                case 2: // pentagonal
                    objects[i] = (int n) -> n * (3 * n - 1) / 2;
                    break;

                case 3: // hexagonal
                    objects[i] = (int n) -> n * (2 * n - 1);
                    break;

                case 4: // heptagonal
                    objects[i] = (int n) -> n * (5 * n - 3) / 2;
                    break;

                case 5: // octagonal
                    objects[i] = (int n) -> n * (3 * n - 2);
                    break;

                default:
                    break;
            }

            for (int j = 1; objects[i].calculate(j) < 10000; j++) {
                matrix[i][objects[i].calculate(j)] = true;
            }
        }
    }

    private static boolean searchNext(int number, int index, int[] answers) {

        int n = number % 100;

        if (number < 1010 || n < 10) {
            answers[index] = 0;
            return false;
        }

        answers[index] = number;
        for (int i = 0; i < 6; i++) {

            boolean success = false;
            if (startingIndex != i && answers[i] == 0) {

                for (int j = n * 100; j < (n + 1) * 100; j++) {

                    if (matrix[i][j]) {

                        answers[i] = j;

                        if (isFilled(answers)) {

                            if (j % 100 == answers[startingIndex] / 100) {
                                System.out.println(Arrays.toString(answers));
                                System.out.println(Arrays.stream(answers).sum());
                                return true;

                            } else {
                                answers[i] = 0;
                            }
                        }
                        success = searchNext(j, i, answers);
                    }
                    if (success) {
                        break;
                    }
                }

                if (success) {
                    return true;
                }
            }

        }
        answers[index] = 0;
        return false;
    }

    private static boolean isFilled(int[] array) {

        for (int i : array) {
            if (i == 0) {
                return false;
            }
        }

        return true;
    }

    @FunctionalInterface
    public interface Number {

        int calculate(int i);
    }
}
