package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Faculty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte gebe eine ganze nicht-negative Zahl ein:");
		int number = sc.nextInt();
		sc.close();
		System.out.println(calculateFaculty(number));
	}
	
	public static long calculateFaculty(int number) {
		if (number == 0 || number == 1) {
			return 1;
		} else {
			return calculateFaculty(number - 1) * number;
		}
	}

}
