package de.dhbwka.java.other;

import java.util.Scanner;

public class DivisionCalculator {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			double a, b, quotient;
			System.out.println("Enter a: ");
			a = sc.nextDouble();
			System.out.println("Enter b: ");
			b = sc.nextDouble();
			if (b != 0) {
				quotient = a / b;
				System.out.println(quotient);
			} else {
				System.out.println("Invalid input. b cannot be 0.");
			}
		}

	}

}
