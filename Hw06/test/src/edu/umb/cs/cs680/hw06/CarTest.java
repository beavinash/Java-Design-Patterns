/**
 * 
 */
package edu.umb.cs.cs680.hw06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
 * @author avinashreddy
 *
 */
public class CarTest {

	@Test
	public void mainTest() {
		// TODO Auto-generated method stub
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(new Car(87000,2016,"Tesla Model S",4100f));
		cars.add(new Car(35000,2017,"Tesla Model 3",5100f));
		cars.add(new Car(88000, 2015, "Tesla Model X",7100f));
		cars.add(new Car(18000,2011,"Honda(A)",3100f));
		cars.add(new Car(28000, 2012,"Audi(S)",2100f));
		
		System.out.println("Price | Year |  Model Name | Mileage");
		for(Car carObject: cars){
			System.out.println(carObject.getPrice()+" |  "+carObject.getYear()+" |  "+carObject+" | "+carObject.getMileage());
		}
		System.out.println();
		
		System.out.println("******Sorting Results Display******");
		Collections.sort(cars, new YearComparator());
		System.out.println("YearComparator: "+cars);
		Collections.sort(cars, new MileageComparator());
		System.out.println("MileageComparator: "+cars);
		Collections.sort(cars, new PriceComparator());
		System.out.println("PriceComparator: "+cars);
		Collections.sort(cars, new ParetoComparator(cars));
		System.out.println("ParetoComparator: "+cars);
		
	}
	
	@Test
	public void priceTest() {
		// TODO Auto-generated method stub
		
		int actual;
		int expected;
		
		ArrayList<Car> cars = new ArrayList<Car>();
		
		cars.add(new Car(28000, 2012,"Audi(S)",2100f));
		
		System.out.println("Price | Year |  Model Name | Mileage");
		int price = 0;
		for(Car carObject: cars){
			price = carObject.getPrice();
			System.out.println(carObject.getPrice()+" |  "+carObject.getYear()+" |  "+carObject+" | "+carObject.getMileage());
		}
		
		actual = price;
		expected = 28000;

		assertThat(actual, is(expected));
		
		
		
	}
	
	@Test
	public void yearTest() {
		// TODO Auto-generated method stub
		
		int actual;
		int expected;
		
		ArrayList<Car> cars = new ArrayList<Car>();
		
		cars.add(new Car(28000, 2012,"Audi(S)",2100f));
		
		System.out.println("Price | Year |  Model Name | Mileage");
		int year = 0;
		for(Car carObject: cars){
			year = carObject.getYear();
			System.out.println(carObject.getPrice()+" |  "+carObject.getYear()+" |  "+carObject+" | "+carObject.getMileage());
		}
		
		actual = year;
		expected = 2012;

		assertThat(actual, is(expected));
		
		
		
	}

}
