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
public interface AreaCalculator {
	public float getArea(ArrayList<Point> points);
	public float getPoints(Point start, Point end);
}
