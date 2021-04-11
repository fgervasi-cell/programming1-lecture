package de.dhbwka.java.other;

import java.util.Scanner;

public class PrimeNumberValidator {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("Please enter a integer number: ");
			int p = sc.nextInt();
			for (int i = 2; i < p; i++) {
				if (p % i == 0) {
					System.out.println(p + " is no prime number!");
					break;
				} else if (i == p - 1) {
					System.out.println(p + " is a prime number!");
				}
			}
		}

	}

}
