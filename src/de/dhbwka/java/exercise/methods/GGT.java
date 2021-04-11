package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class GGT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte gebe die erste Zahl ein:");
		int number1 = sc.nextInt();
		System.out.println("Bitte gebe die zweite Zahl ein:");
		int number2 = sc.nextInt();
		sc.close();
		System.out.println(berechneGGT(number1,number2));
	}
	
	public static int berechneGGT(int number1, int number2) {
		int rest = number1 % number2;
		if (rest == 0) {
			return number2;
		} else {
			return berechneGGT(number2, rest);
		}
	}

}
