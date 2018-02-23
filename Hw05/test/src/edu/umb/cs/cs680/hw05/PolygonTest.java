/**
 * 
 */
package edu.umb.cs.cs680.hw05;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author avinashreddy
 *
 */


import static org.hamcrest.CoreMatchers.*;


import java.awt.Point;
import java.util.ArrayList;



public class PolygonTest {
	@Test
	public void getPointsTest() {

		ArrayList<Point> points;
		float area1;
		float actual;
		float expected;
		
		points = new ArrayList<Point>(); 
		points.add(new Point(0,0));
		points.add(new Point(0,6)); 
		points.add(new Point(6,0));
		
		Polygon p = new Polygon(points, new TriangleAreaCalc()); 
		area1 = p.getArea();

		actual = area1;
		expected = 18.0f;

		assertThat(actual, is(expected));
	}

	@Test
	public void getAreaTest() {
		
		ArrayList<Point> points;
		float area1;
		float actual;
		float expected;

		points = new ArrayList<Point>(); 
		points.add(new Point(0,0));
		points.add(new Point(0,6)); 
		points.add(new Point(6,0));  
		Polygon p = new Polygon(points, new TriangleAreaCalc()); 
		Point point = new Point(6,6);
		p.addPoint(point);
		p.setAreaCalc(new RectangleAreaCalc());
		area1 = p.getArea();

		actual = area1;
		expected = 36.0f;

		assertThat(actual, is(expected));
	}

}
