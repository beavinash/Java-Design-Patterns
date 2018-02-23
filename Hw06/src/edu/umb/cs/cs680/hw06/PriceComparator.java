/**
 * 
 */
package edu.umb.cs.cs680.hw06;
import java.util.*;

/**
 * @author avinashreddy
 *
 */
public class PriceComparator implements Comparator<Car> {
	public int compare(Car car1, Car car2){
		return car2.getPrice()-car1.getPrice();
	} 
}
