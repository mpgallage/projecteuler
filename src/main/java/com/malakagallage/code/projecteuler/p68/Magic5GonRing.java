package com.malakagallage.code.projecteuler.p68;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author : maal (Malaka Gallage)
 * @since : 24/04/18
 */
public class Magic5GonRing {
		
	private static List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

    	List<Integer> list = new ArrayList<>();
    	long max = 0;
    	
    	for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
    	
    	permute(list, 0);
    	
    	for (String s : answers) {
    		
    		long l = Long.parseLong(s);
    		
    		if (max < l) max = l;
    	}
    	
    	System.out.println(max);
    }
    
    private static void permute(List<Integer> list, int k) {
    	
        for(int i = k; i < list.size(); i++) {
        	
            Collections.swap(list, i, k);
            permute(list, k+1);
            Collections.swap(list, k, i);
        } 
        
        if (k == list.size() - 1) {
            
        	Integer[] arr = new Integer[10];
        	String s = isGonRing(list.toArray(arr));
        	
        	if (s != null && s.length() == 16) {
        		answers.add(s);
        	}
        }
    }
    
    private static String isGonRing(Integer[] arr) {
    	
    	int[] out = new int[5];
    	StringBuffer sb = new StringBuffer();
    	int num = arr[0] + arr[5] + arr[6];

    	for (int i = 0; i < 5; i++) {
    		
    		int k = i == 4 ? 5 : 6 + i;
    		int n = arr[i] + arr[5 + i] + arr[k];
    		
    		if (num != n) {
    			return null;
    		}
    		
    		out[i] = Integer.parseInt(arr[i] + "" +  arr[5 + i] + "" + arr[k]);
    	}
    	
    	int minIndex = 0;
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < out.length; i++) {
			
    		if (min > out[i]) {
    			min = out[i];
    			minIndex = i;
    		}
		}
    	
    	for (int i = minIndex; i < out.length + minIndex; i++) {
    		
    		int j = i;
    		
    		if (j >= 5) j -= 5;
    		
    		sb.append(out[j]);
    		
    	}
    	
    	return sb.toString();
    }
}
