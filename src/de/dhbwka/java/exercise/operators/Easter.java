package de.dhbwka.java.exercise.operators;

import java.util.Scanner;

public class Easter {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Bitte geben Sie eine Jahreszahl ein: ");
			double jahr = sc.nextInt();
			double a = jahr % 19;
			double b = jahr % 4;
			double c = jahr % 7;
			double k = jahr / 100;
			double p = (8 * k + 13) / 25;
			double q = k / 4;
			double m = (15 + k - p - q) % 30;
			double n = (4 + k - p) % 7;
			double d = (19 * a + m) % 30;
			double e = (2 * b + 4 * c + 6 * d + n) % 7;
			int ostern = (int) (22 + d + e) + 1;
			if (ostern <= 31) {
				System.out.println("Ostern ist/war in diesem Jahr am " + ostern + ". März");
			} else {
				System.out.println("Ostern ist/war in diesem Jahr am " + (ostern - 31) + ". April");
			}
		}

	}

}
