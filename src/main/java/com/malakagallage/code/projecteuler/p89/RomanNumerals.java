package com.malakagallage.code.projecteuler.p89;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/17
 */
public class RomanNumerals {
	
	private static final String[] numbers = new String[1000];
	
	public static void main(String[] args) throws Exception {
        
		init();
		
		int answer = 0;
		
        for(String oldRoman : numbers) {
        	
        	int oldLen = oldRoman.length();
        	int num = convertToInt(oldRoman);
        	
        	String newRoman = convertToRoman(num);
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
    		num += R.valueOf(c).getVal();
    	}
    	return num;
	}
	
	private static String convertToRoman(int n) {
		
		String s = "";
		for (int i = 6; i >= 0; i--) {
			
			
			R r = R.values()[i];
			int d = r.value;
			int a = n / d;
			
			if (a != 0) {
				
				if (a == 4 || a == 9) {
					s += optimize(a * d);
				} else {
					s += r.convert(a);
				}
				n -= a * d;
				if (n == 0) break;
			}
		}
		
		return s;
	}
	
	private static String optimize(int n) {
		
		String s = "";
						
		switch (n) {
			case 4:
				s = "IV";
				break;
			case 9:
				s = "IX";
				break;
			case 40:
				s = "XL";
				break;
			case 90:
				s = "XC";
				break;
			case 400:
				s = "CD";
				break;
			case 900:
				s = "CM";
				break;
			default:
				break;
		}
		
		return s;
	}
	
	private enum R {
		
		I(1),
		V(5),
		X(10),
		L(50),
		C(100),
		D(500),
		M(1000);
		
		private final int value;
		
		R(int value) {
			this.value = value;
		}
		
		public int getVal() {
			return value;
		}
		
		public String convert(int count) {
			
			String s = "";
			
			for (int i = 0; i < count; i++) {
				s += this.toString();
			}
			
			return s;
		}
	}
}
