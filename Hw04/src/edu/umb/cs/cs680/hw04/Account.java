/**
 * 
 */
package edu.umb.cs.cs680.hw04;

/**
 * @author avinashreddy
 *
 */
public abstract class Account {
	protected float balance = 0;
	
	
	public float getBalance() {
		return this.balance;
	}
	
	public float deposit(float amount) {
		this.balance = this.balance + amount;
		return this.balance;
	}
	
	public abstract float withdraw(float amount) throws InsufficientFundsException; 
	
}
