package com.malakagallage.code.projecteuler.p79;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

import com.malakagallage.code.projecteuler.util.EulerUtils;
/**
 * @author : maal (Malaka Gallage)
 * @since : 04/04/18
 */
public class Passcodederivation {
	
    public static void main(String[] args) throws IOException {
    	
    	List<String> list = new ArrayList<String>();
    	
    	FileReader fr = new FileReader("src/main/resources/p079_keylog.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int n = 0;
        
        while ((line = br.readLine()) != null) {
        	
        	list.add(line);
        }
        
        br.close();
        fr.close();
        
        String given = "98763210";
        for (int i = 0; i < 5; i++) {
        	
        	for (int j = 0; j < 8; j++) {
        		
        		String prefix = "";
        		for (int k = 0; k < i; k++) {
        			prefix += given.charAt(j);
        		}
        		
        		String code = prefix + given;
        		
        		List<String> perm = new ArrayList<>();
                permutation(code, perm);
                
               for (String per : perm) {
                	//System.out.println(per);
                	int l = 1;
                	for (String s : list) {
                		
                		if (isValid(per, s.toCharArray())) {
                			l++;
                			continue;
                		}
                		break;
                	}
                	
                	if (l == list.size()) {
                		System.out.println("#######################-- " + per);
                		break;
                	}
                }
        		
        	}
        }
        
    }
    
    
    private static boolean isValid(String s, char[] c) {
    	
    	for (int i = 0; i < s.length(); i++) {
    		
    		if (s.charAt(i) == c[0]) {
    			
    			for (int j = i + 1; j < s.length(); j++) {
    				
    				if (s.charAt(j) == c[1]) {
    					
    					for (int k = j + 1; k < s.length(); k++) {
    						
    						if (s.charAt(j) == c[1]) {
    							return true;
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    private static void permutation(String s, List<String> l) {
    	
    	permutation("", s, l);
    }
    
    private static void permutation(String prefix, String s, List<String> l) {
    	
    	int n = s.length();
    	
    	if (n == 0) {
    		l.add(prefix);
    	
    	} else {
    		for (int i = 0; i < n; i++) {
    			permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), l);
    		}
    	}
    }
}
