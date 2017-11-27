package com.malakagallage.code.projecteuler.p59;

import java.util.stream.Stream;
import java.io.*;

/**
 * @author : maal (Malaka Gallage)
 * @since : 25/11/17
 */
public class XORDecryption {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/main/resources/p059_cipher.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        Integer[] array = Stream.of(line.split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        printSpaceCountForEachLetter(array);
        checkKey(array, "god".toCharArray());

        br.close();
        fr.close();
    }

    private static void printSpaceCountForEachLetter(Integer[] array) {

        char[] result = new char[array.length];
        System.out.println("Letter\tSpace Count");

        for (int j = 97; j <= 122; j++) {

            int spaceCount = 0;

            for (int i = 0; i < result.length; i++) {

                result[i] = (char) (array[i] ^ j);

                if (result[i] == ' ') {
                    spaceCount++;
                }
            }

            System.out.println("\t" + (char) j + "\t\t" + spaceCount);
        }
    }

    private static void checkKey(Integer[] array, char[] key) {

        char[] result = new char[array.length];
        long count = 0;

        for (int i = 0; i < array.length; i++) {

            result[i] = (char) (array[i] ^ key[i % 3]);
            count += result[i];
        }

        System.out.println(new String(result));
        System.out.println("Character Count = " + count);
    }
}
