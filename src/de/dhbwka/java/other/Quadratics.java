package de.dhbwka.java.other;

import java.util.Scanner;

public class Quadratics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, c;
		System.out.println("Bitte geben Sie den Koeffizienten a ein: ");
		a = sc.nextInt();
		System.out.println("Bitte geben Sie den Koeffizienten b ein: ");
		b = sc.nextInt();
		System.out.println("Bitte geben Sie den Koeffizienten c ein: ");
		c = sc.nextInt();
		if (a == 0) {
			if (b == 0) {
				System.out.println("Die Gleichung ist degeneriert.");
			} else {
				double x = -(c / b);
				System.out.println(x);
			}

		} else {
			double D = (b * b) - (4 * a * c);
			if (D >= 0) {
				double x1, x2;
				x1 = ((-b + Math.sqrt(D)) / (2 * a));
				x2 = ((-b - Math.sqrt(D)) / (2 * a));
				System.out.println(x1);
				System.out.println(x2);
			} else {
				System.out.println("Die Lösung ist konjugiert komplex.");
			}
		}
		sc.close();
	}

}
