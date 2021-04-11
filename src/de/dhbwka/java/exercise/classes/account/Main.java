package de.dhbwka.java.exercise.classes.account;

public class Main {

	public static void main(String[] args) {
		Account account = new Account(4711, "Donald Duck", 500.0, 1000.0);
		System.out.println(account);
		account.deposit(200);
		System.out.println(account);
		account.payout(400);
		System.out.println(account);
		account.payout(2000);
		System.out.println(account);
	}

}
