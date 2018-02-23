/**
 * 
 */
package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author avinashreddy
 *
 */
public class TriangleAreaCalc implements AreaCalculator {
	protected float areaOfTriangle;
	private Point a, b, c;

	@Override
	public float getArea(ArrayList<Point> points) {
		float s1;
		float s2;
		float s3;
		float s;
		this.a = points.get(0);
		this.b = points.get(1);
		this.c = points.get(2); 
		s1 = getPoints(a ,b); 
		s2 = getPoints(a ,c); 
		s3 = getPoints(b ,c);
		s = (s1 + s2 + s3)/2; 
		areaOfTriangle = (float) Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
		return areaOfTriangle;
	} 
	
	public float getPoints(Point start, Point end){ 
		
		float length;
		int startx;
		
		
		startx = start.x; 
		int starty;
		starty = start.y; 
		int endx;
		endx = end.x; 
		int endy;
		endy = end.y; 	
		length = (float) Math.sqrt((startx - endx) * (startx - endx) + (starty - endy) * (starty - endy)); 
		return length;
	}

	
}
