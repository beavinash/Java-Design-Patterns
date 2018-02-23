/**
 * 
 */
package edu.umb.cs.cs680.hw04;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;

//import edu.umb.cs.cs680.hw04.*;

//import org.hamcrest.Matcher;
import org.junit.Test;



/**
 * @author avinashreddy
 *
 */
public class CheckingAccountTest {
	
	CheckingAccount checkinAccount;
	
	@Before
	public void setbalCheckings() {
		
		
		SavingsAccount savingsAccount = new SavingsAccount(1000);
		checkinAccount = new CheckingAccount(savingsAccount,1000);
	}
	
	@Test
	public void getBalanceTestCheckings() {
		
		float actual = checkinAccount.getBalance();
		float expected = 1000;
		assertThat(actual,is(expected));
		
	}
	
	@Test
	public void withdrawTest() throws InsufficientFundsException {
		checkinAccount.deposit(3000);
		float actual = checkinAccount.withdraw(800);
		float expected = 3200;
		assertThat(actual,is(expected));	
	}
	
	@Test(expected=InsufficientFundsException.class) 
	public void withdrawMoreThanBalance() throws InsufficientFundsException {
		checkinAccount.deposit(1200);
		checkinAccount.withdraw(3400);	
	}

}
