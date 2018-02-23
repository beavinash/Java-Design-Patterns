package edu.umb.cs.cs680.hw04;

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException() {
		System.err.println("Insufficient Funds in an Accont");
	}

}
