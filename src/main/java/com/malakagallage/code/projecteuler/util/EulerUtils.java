package com.malakagallage.code.projecteuler.util;

import static com.malakagallage.code.projecteuler.util.EulerUtils.doubleToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author : maal (Malaka Gallage)
 * @since : 25/11/17
 */
public class EulerUtils {

	private static final BigDecimal SQRT_DIG = new BigDecimal(150);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());

    private static List<Double> primes;
    static {
        primes = new ArrayList<>();
        primes.add(2d);
        primes.add(3d);
    }
    
    public enum Numeral {
    	
    	NUMERATOR(0),
    	DENOMINATOR(1);
    	
    	private final int val;
    	
    	Numeral(int val) {
    		this.val = val;
    	}
    	
    }

    /**
     * @param n number to check whether prime
     * @return true if prime. false otherwise
     */
    public static boolean isPrime(double n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * (Recursive method- high memory consumption)
     * @param n number to check whether prime
     * @return true if prime. false otherwise
     */
    public static boolean isPrimeRec(double n) {
        return isPrime(n, 2);
    }

    public static boolean isPrime(double n, long d) {

        return n == 2 || !(n < 2 || n % d == 0) && (d > Math.sqrt(n) || isPrime(n, ++d));
    }

    /**
     * @param i input integer
     * @return sum of all the digits of input
     */
    public static long digitSum(BigInteger i) {

        String number = i.toString();
        long sum = 0;

        for (char c : number.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }

        return sum;
    }

    /**
     * @param d input number
     * @return A string with all digits without any decimal points and without scientific notation
     */
    public static String doubleToString(double d) {

        DecimalFormat df = new DecimalFormat("#");
        return df.format(d);
    }


    /**
     * @param n given number
     * @return reverse digit order of the given number
     */
    public static double reverse(double n) {

        char[] arr = doubleToString(n).toCharArray();

        for (int i = 0; i < arr.length/2; i++) {
            char c = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = c;
        }

        return Double.parseDouble(new String(arr));
    }

    /**
     * @param n input number
     * @return check whether number is palindromic
     */
    public static boolean isPalindromic(double n) {

        char[] arr = doubleToString(n).toCharArray();

        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param a first number
     * @param b second number
     * @return concatenated value of a nd b
     */
    public static double concatenateDouble(double a , double b) {

        return Double.parseDouble(doubleToString(a) + doubleToString(b));
    }

    /**
     * @param d input number
     * @return next prime number
     */
    public static double getNextPrime(double d) {

        if (d < 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }

        if (d == 0 || d == 1) {
            return 2d;
        }

        for (int i = 0; i < primes.size(); i++) {

            if (d <= primes.get(i)) {
                if (i < primes.size() - 1) {
                    return primes.get(i + 1);
                }
            }
        }

        boolean prime;
        double nextOddNumber = primes.get(primes.size()-1) + 2;

        for (double n = nextOddNumber; true; n += 2) {

            prime = true;
            for (int j = 0; Math.sqrt(n) >= primes.get(j); j++) {

                if (n % primes.get(j) == 0) {
                    prime = false;
                    break;
                }

            }

            if (prime) {
                primes.add(n);
                if (n > d) {
                    return n;
                }
            }
        }
    }

    /**
     * @param size length of the series
     * @return prime number series
     */
    public static List<Double> populatePrimes(int size) {

        List<Double> primes = new ArrayList<>(size);
        primes.add(2d);

        for (double n = 3; size > primes.size(); n += 2) {

            boolean prime = true;
            for (int j = 0; Math.sqrt(n) >= primes.get(j); j++) {

                if (n % primes.get(j) == 0) {
                    prime = false;
                    break;
                }

            }

            if (prime) {
                primes.add(n);
            }
        }

        return primes;
    }

    /**
     * @param a first string
     * @param b second string
     * @return true if a and b are permutations. false otherwise
     */
    public static boolean isPermutation(double a, double b) {

        return isPermutation(doubleToString(a), doubleToString(b));
    }

    /**
     * @param a first string
     * @param b second string
     * @return true if a and b are permutations. false otherwise
     */
    public static boolean isPermutation(String a, String b) {

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);

        return Arrays.equals(x, y);
    }

    /**
     * @param d input number
     * @return number of digits
     */
    public static long numberOfDigits(double d) {

        return doubleToString(d).length();
    }
    
    /**
     * @param x
     * @return the continued fraction list of x
     */
    public static List<Double> expand(double x) {
    	
    	List<Double> list = expand(x, Math.floor(Math.sqrt(x)), 1, 0, 0);
    	list.add(Math.floor(x));
    	Collections.reverse(list);
    	
    	return list;
    }
    
    private static List<Double> expand(double x, double a, double b, double startA, double startB) {		// b/(Math.sqrt(x) - a)

        double decider = (x - a * a);

        if (decider <= 0 || x <= 1 || a <= 0 || b <= 0) {
            return null;
        }
        
        if (startA == a && startB == b) {
            return new ArrayList<>();
        }
        
        if (startA == 0 || startB == 0) {
            startA = a;
            startB = b;
        }

        double nextB = decider / b;
        double nextA = startA - ((a + startA) % (decider / b));

        long y = (long) (b * (a + startA) / decider);
        
        List<Double> list = expand(x, nextA, nextB, startA, startB);
        if (list != null) {
            list.add(new Double(y));
            return list;
        }

        return null;
    }
    
    /**
     * @param list continued fraction list
     * @return numerator or denominator of the convergent fraction
     */
    public static BigInteger continuedFractionConvergence(List<Double> list, Numeral numeral) {
    	
        int size = list.size();
        BigInteger[] x = new BigInteger[size];
        BigInteger[] y = new BigInteger[size];

        x[size - 1] = new BigInteger(doubleToString(list.get(size - 1)));
        y[size - 1] = BigInteger.ONE;

        for (int i = size - 2; i >= 0; i--) {

            x[i] = x[i + 1].multiply(new BigInteger(doubleToString(list.get(i)))).add(y[i + 1]);
            y[i] = x[i + 1];
        }
        
        if (numeral == Numeral.DENOMINATOR) {
        	return y[0];
        }
        
        return x[0];
    }
    
    public static double gcd(double a, double b) {
        BigInteger b1 = new BigInteger(doubleToString(a));
        BigInteger b2 = new BigInteger(doubleToString(b));
        BigInteger gcd = b1.gcd(b2);
        return Double.parseDouble(gcd.toString());
    }
    
    /**
     * Private utility method used to compute the square root of a BigDecimal.
     * 
     * @author Luciano Culacciatti 
     * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
     */
    private static BigDecimal sqrtNewtonRaphson(BigDecimal c, BigDecimal xn, BigDecimal precision) {
        
    	BigDecimal fx = xn.pow(2).add(c.negate());
        BigDecimal fpx = xn.multiply(new BigDecimal(2));
        BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(), RoundingMode.HALF_DOWN);
        
        xn1 = xn.add(xn1.negate());
        BigDecimal currentSquare = xn1.pow(2);
        BigDecimal currentPrecision = currentSquare.subtract(c);
        currentPrecision = currentPrecision.abs();
        
        if (currentPrecision.compareTo(precision) <= -1) {
            return xn1;
        }
        
        return sqrtNewtonRaphson(c, xn1, precision);
    }

    /**
     * Uses Newton Raphson to compute the square root of a BigDecimal.
     * 
     * @author Luciano Culacciatti 
     * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
     */
    public static BigDecimal sqrtNewtonRaphson(BigDecimal c) {
    	
        return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
    }
}
