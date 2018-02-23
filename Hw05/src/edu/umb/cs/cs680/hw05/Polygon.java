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
public class Polygon {
	private ArrayList<Point> points; 
	public AreaCalculator areaCalculate; 
	
	public Polygon(ArrayList<Point> points, AreaCalculator areaCalc){ 
		this.points = points; 
		this.areaCalculate = areaCalc; 
	}
	
	public void setAreaCalc(AreaCalculator areaCalc){ 
		this.areaCalculate = areaCalc; 
	}
	
	public void addPoint(Point point){
		this.points.add(point);
	}
	
	public float getArea(){ 
		return areaCalculate.getArea(points); 
	}
}
