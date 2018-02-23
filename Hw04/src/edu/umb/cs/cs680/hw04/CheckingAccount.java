/**
 * 
 */
package edu.umb.cs.cs680.hw04;

/**
 * @author avinashreddy
 *
 */
public class CheckingAccount extends Account {
	
	float savingsBal;
	SavingsAccount savingsAccount;

		
	public CheckingAccount(SavingsAccount savingsAccount, float cash) {
		this.savingsAccount = savingsAccount;
		this.balance += cash;
		System.out.println("Saving Account is selected for CheckIn " + savingsAccount.getBalance());
		
		
	}
	
	public float deposit(float depositValue) {
		this.balance += depositValue;
		return this.getBalance();
	}

	public float withdraw(float amount) throws InsufficientFundsException {
		if (this.getBalance() > amount ) {
			this.balance = this.getBalance() - amount;
			return this.balance;
		}
		
		else if (savingsAccount.getBalance() + this.getBalance() >= amount ) {
			this.balance -= amount + 50;
		}
		
		else if (savingsAccount.getBalance() + this.getBalance() < amount) throw new InsufficientFundsException();
		
		else if (this.getBalance() < 0 ) throw new InsufficientFundsException();
		
		return this.balance;
	}
}
