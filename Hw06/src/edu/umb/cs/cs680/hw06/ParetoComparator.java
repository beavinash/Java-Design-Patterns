/**
 * 
 */
package edu.umb.cs.cs680.hw06;


import java.util.*;

/**
 * @author avinashreddy
 *
 */
public class ParetoComparator implements Comparator<Car> {
	public ParetoComparator(ArrayList<Car> cars) {
		
		for(Car carObject: cars){
		 carObject.setCars(cars);
		}
	}

	public int compare(Car car1, Car car2){
		return car2.getDominationCount()-car1.getDominationCount();
	} 
}
