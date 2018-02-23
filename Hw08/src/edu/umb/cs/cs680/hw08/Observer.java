/**
 * 
 */
package edu.umb.cs.cs680.hw08;

import java.lang.reflect.Field;

/**
 * @author avinashreddy
 *
 */
abstract class Observer<T> {
	public abstract void update(Observable o, Object arg);
}
