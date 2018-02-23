/**
 * 
 */
package edu.umb.cs.cs680.hw06;
import java.util.*;

/**
 * @author avinashreddy
 *
 */
public class Car {
	private int price;
	private int year;
	private String name;
	private float mileage;
	private ArrayList<Car> cars;

	public Car(int price, int year, String name,  float mileage){
		this.price = price;
		this.year = year;
		this.name = name;
		this.mileage = mileage;
	}
	
	public int getYear(){
		return this.year;
	}

	public float getMileage(){
		return this.mileage;
	}

	public int getPrice(){
		return this.price;
	}	
	
	public String toString(){
		return this.name;
	}
	
	public void setCars(ArrayList<Car> cars){
		this.cars=cars;
	}
	
	public int getDominationCount(){
		int countNumber = 0;
		for (Car carObject: this.cars){
			if (this.price==carObject.getPrice() && this.year==carObject.getYear() && this.mileage==carObject.getMileage())
			{
				continue;
			}
			if (this.price>=carObject.getPrice() && this.year<=carObject.getYear() && this.mileage>=carObject.getMileage())
			{
				countNumber++;
			}
		}
		return countNumber;
	}
}
