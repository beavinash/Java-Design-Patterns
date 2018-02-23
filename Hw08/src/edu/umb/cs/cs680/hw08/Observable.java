/**
 * 
 */
package edu.umb.cs.cs680.hw08;

import java.util.ArrayList;
import java.util.*;

/**
 * @author avinashreddy
 *
 */
import java.util.ArrayList;
import java.util.*;


public class Observable {
	private ArrayList<Observer> observers;
	private boolean changed;

	Observable() {
		observers = new ArrayList<>();
		changed = false;
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void setChanged() {
		this.changed = true;
	}

	public boolean hasChanged() {
		return this.changed;
	}

	public void clearChanged() {
		this.changed = false;
	}

	public void notifyObservers() throws IllegalAccessException {
	    notifyObservers(null);
    }

	public void notifyObservers(Object arg) {
        if (hasChanged()) {
            for (Observer observer : this.observers)
                observer.update(this, arg);
            clearChanged();
        }
    }
}
