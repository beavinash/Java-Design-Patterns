/**
 * 
 */
package edu.umb.cs.cs680.hw05;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author avinashreddy
 *
 */
public class DynamicTest {

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
		points.add(new Point(6,6)); 
		Polygon p = new Polygon(points, new RectangleAreaCalc()); 
		area1 = p.getArea();

		actual = area1;
		expected = 36.0f;

		assertThat(actual, is(expected));
	}

}
