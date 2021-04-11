package de.dhbwka.java.exercise.classes.account;

public class Account {
	private int accountId;
	private String accountOwner;
	private double accountBalance;
	private double accountLimit;

	Account(int accountId, String accountOwner, double accountBalance, double accountLimit) {
		this.setAccountId(accountId);
		this.setAccountOwner(accountOwner);
		this.accountBalance = accountBalance;
		this.accountLimit = accountLimit;
	}
	
	public void deposit(double amount) {
		this.accountBalance += amount;
	}
	
	public void payout(double payout) {
		if ((this.accountBalance - payout) < -accountLimit) {
			System.out.println(generateExceptionMessage());
		} else {
			this.accountBalance -= payout;
		}
	}
	
	private String generateExceptionMessage() {
		return "Deckung nicht ausreichend!";
	}
	
	public double getAccountBalance() {
		return this.accountBalance;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public String toString() {
		return "Konto Nr. " + accountId + "(" + accountOwner + "), Stand: " + accountBalance + " ct, Limit " + accountLimit + " ct"; 
	}
}
