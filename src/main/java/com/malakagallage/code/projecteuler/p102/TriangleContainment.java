package com.malakagallage.code.projecteuler.p102;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author : maal (Malaka Gallage)
 * @since : 18/04/17
 */
public class TriangleContainment {
	
	private static final Point[][] points = new Point[1000][3];
	private static final Point origin = new Point(0, 0);
	
	public static void main(String[] args) throws Exception {
				
		int count = 0;
		
		FileReader fr = new FileReader("src/main/resources/p102_triangles.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line;
        int i = 0;
        
        while ((line = br.readLine()) != null) {
        	
        	String[] split = line.split(",");
        	
    		Point p1 = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    		Point p2 = new Point(Integer.parseInt(split[2]), Integer.parseInt(split[3]));
    		Point p3 = new Point(Integer.parseInt(split[4]), Integer.parseInt(split[5]));

    		points[i][0] = p1;
    		points[i][1] = p2;
    		points[i][2] = p3;
    		
        	i++;
        }
        
        try {
        	fr.close();
        	br.close();
        } catch (Exception e) {
			// ignore
		}
        
        for(Point[] pts : points) {
        	
        	if (isPointInTriangle(origin, pts[0], pts[1], pts[2])) {
        		count++;
        	}
        }
        
        System.out.println(count);
	}
	
	private static float sign (Point p1, Point p2, Point p3) {
	    return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
	}

	private static boolean isPointInTriangle (Point pt, Point v1, Point v2, Point v3) {
	    boolean b1, b2, b3;

	    b1 = sign(pt, v1, v2) < 0;
	    b2 = sign(pt, v2, v3) < 0;
	    b3 = sign(pt, v3, v1) < 0;

	    return ((b1 == b2) && (b2 == b3));
	}
	
	static class Point {
		
		int x;
		int y;
		
		public  Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
