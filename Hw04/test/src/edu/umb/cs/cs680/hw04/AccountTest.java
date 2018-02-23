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
public class AccountTest {
	
	SavingsAccount savingsAccount;

	@Before
	public void getBalanceTestSavings() {
		
		savingsAccount = new SavingsAccount(1000);
		
	}
	
	

	@Test
	public void getBalanceTestCheckings() {
		
		savingsAccount.deposit(1000);
		float actual = savingsAccount.getBalance();
		float expected = 2000;
		assertThat(actual,is(expected));
		
	}
	
	
	
	@Test
	public void setbalSavings() {
		
		float actual = savingsAccount.getBalance();
		float expected = 1000;
		assertThat(actual,is(expected));
		
	}
	
	@Test
	public void setbalChecking() throws InsufficientFundsException {
		
		float actual = savingsAccount.withdraw(100);
		float expected = 900;
		assertThat(actual,is(expected));
		
	}

}
