package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Norm {

	public static void main(String[] args) {
		System.out.print("Bitte Anzahl der Elemente n eingeben: ");
		Scanner sc = new Scanner(System.in);
		int vectorLength = sc.nextInt();
		int[] vector = new int[vectorLength];
		for (int i = 0; i < vectorLength; i++) {
			System.out.print("Bitte x" + i + " eingeben: ");
			vector[i] = sc.nextInt();
		}
		sc.close();
		double amount = 0;
		for (int number : vector) {
			amount += number * number;
		}
		amount = Math.sqrt(amount);
		System.out.print("Der Betrag des Vektors ist " + amount);
		

	}

}
