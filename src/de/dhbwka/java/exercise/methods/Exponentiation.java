package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Basis ein:");
		double x = sc.nextDouble();
		System.out.println("Bitte geben Sie den positiven ganzzahligen Exponenten ein:");
		int n = sc.nextInt();
		sc.close();
		System.out.println("Ergebnis: " + xPowerN(x, n));
	}
	
	public static double xPowerN(double x, int n) {
		if (n == 0) {
			return 1;
		} else {
			return xPowerN(x, n - 1) * x;
		}
	}

}
