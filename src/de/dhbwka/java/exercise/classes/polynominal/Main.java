package de.dhbwka.java.exercise.classes.polynominal;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Polynominal polynominal1 = new Polynominal(2.0, 0.0, 0.0);
		Polynominal polynominal2 = new Polynominal(0.0, -4.0, 1.0);
		System.out.println("P1: " + polynominal1);
		System.out.println("P2: " + polynominal2);
		System.out.println("P3 = P1 + P2: " + polynominal1.addPolynom(polynominal2));
		System.out.println("P4 = 2.0 * P3: " + polynominal1.addPolynom(polynominal2).multiplicationWithScalar(2.0));
		System.out.println("Nullstellen von P4:");
		System.out.println(Arrays.toString(polynominal1.addPolynom(polynominal2).multiplicationWithScalar(2.0).calculateZeropoints()));
		System.out.println("Funktionswert von P1: f(5)=" + polynominal1.calculateFunctionalValueOf(5));
		System.out.println("Funktionswert von P2: f(3)=" + polynominal2.calculateFunctionalValueOf(3));
		System.out.println("Funktionswert von P4: f(-7)=" + polynominal1.addPolynom(polynominal2).multiplicationWithScalar(2.0).calculateFunctionalValueOf(-7));
	}

}
