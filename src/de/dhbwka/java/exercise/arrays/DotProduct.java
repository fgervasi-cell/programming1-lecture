package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class DotProduct {

	public static void main(String[] args) {
		System.out.print("Bitte Anzahl der Elemente n eingeben: ");
		Scanner sc = new Scanner(System.in);
		int vectorLength = sc.nextInt();
		int[] vector1 = new int[vectorLength];
		int[] vector2 = new int[vectorLength];
		System.out.println("Vektor 1:");
		for (int i = 0; i < vectorLength; i++) {
			System.out.print("Bitte x" + i + " eingeben: ");
			vector1[i] = sc.nextInt();
		}
		System.out.println("Vektor 2:");
		for (int i = 0; i < vectorLength; i++) {
			System.out.print("Bitte x" + i + " eingeben: ");
			vector2[i] = sc.nextInt();
		}
		sc.close();
		double dotProduct = 0;
		for (int i = 0; i < vectorLength; i++) {
			dotProduct += vector1[i] * vector2[i];
		}
		System.out.print("Das Skalarprodukt von Vektor 1 und Vektor 2 beträgt " + dotProduct);

	}

}
