package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean nextNumber = true;
		int number, result = 0;
		while (nextNumber) {
			System.out.print("Zahl eingeben (<0 für Abbruch): ");
			number = sc.nextInt();
			if (number < 0) {
				break;
			} else {
				result += number; 
			}
			
		}
		System.out.print("Summe: " + result);
		sc.close();
	}

}
