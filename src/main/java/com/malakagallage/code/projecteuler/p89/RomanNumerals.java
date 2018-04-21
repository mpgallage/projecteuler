package com.malakagallage.code.projecteuler.p89;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/17
 */
public class RomanNumerals {
	
	private static final String[] numbers = new String[1000];

    private final static TreeMap<Integer, String> roman = new TreeMap<>();
    private final static TreeMap<String, Integer> arabic = new TreeMap<>();

    static {

        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        arabic.put("I", 1);
        arabic.put("V", 5);
        arabic.put("X", 10);
        arabic.put("L", 50);
        arabic.put("C", 100);
        arabic.put("D", 500);
        arabic.put("M", 1000);


    }
	
	public static void main(String[] args) throws Exception {
        
		init();
		
		int answer = 0;
		
        for(String oldRoman : numbers) {
        	
        	int oldLen = oldRoman.length();
        	int num = convertToInt(oldRoman);
        	
        	String newRoman = toRoman(num);
        	int newLen = newRoman.length();
        	
        	answer += oldLen - newLen;
        	
        }
        
        System.out.println(answer);
	}
	
	private static void init() throws Exception {
		
		FileReader fr = new FileReader("src/main/resources/p089_roman.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line;
        int i = 0;
        
        while ((line = br.readLine()) != null) {
        	
        	numbers[i] = line;
    		
        	i++;
        }
        
        try {
        	fr.close();
        	br.close();
        } catch (Exception e) {
			// ignore
		}

	}
	
	private static int convertToInt(String s) {
    	
		s = s.replaceAll("IV", "IIII");
		s = s.replaceAll("IX", "VIIII");

		s = s.replaceAll("XL", "XXXX");
		s = s.replaceAll("XC", "LXXXX");
		
		s = s.replaceAll("CD", "CCCC");
		s = s.replaceAll("CM", "DCCCC");

		String[] split = s.split("");
    	int num = 0;
    	
    	for (String c : split) {
    		num += arabic.get(c);
        }
    	return num;
	}

    public static String toRoman(int number) {
        int l =  roman.floorKey(number);
        if ( number == l ) {
            return roman.get(number);
        }
        return roman.get(l) + toRoman(number-l);
    }

}
