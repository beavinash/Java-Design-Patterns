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
public class RectangleAreaCalc implements AreaCalculator {
	private Point a, b, c, d;
	private	float area;
	
	@Override
	public float getArea(ArrayList<Point> points) {
		this.a = points.get(0);
		this.b = points.get(1);
		this.c = points.get(2);
		this.d = points.get(3);
		
		float length = getPoints(a,b); 
		float width = getPoints(a,c); 
		
		area = length * width; 
		return area;
	}
	
	public float getPoints(Point start, Point end){ 
		int strtx = start.x;
		int strty = start.y; 
		int endx = end.x; 
		int endy = end.y; 
		
		float length = (float) Math.sqrt((strtx - endx)*(strtx - endx) + (strty - endy)*(strty - endy)); 
		return length; 
	}
}
