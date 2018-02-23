/**
 * 
 */
package edu.umb.cs.cs680.hw04;



/**
 * @author avinashreddy
 *
 */
public class SavingsAccount extends Account {
	
	
	
	
	public SavingsAccount(float newBalance) {
		this.balance = newBalance;
	}

	
	public float deposit(float depositMoney) {
		this.balance += depositMoney;
		return this.balance;
	}
	
	@Override
	public float withdraw(float amount) throws InsufficientFundsException {
		if (this.getBalance() > amount) {
			this.balance = this.balance - amount;
		} else if (this.getBalance() < amount) throw new InsufficientFundsException();
		return this.balance;
	}
}
