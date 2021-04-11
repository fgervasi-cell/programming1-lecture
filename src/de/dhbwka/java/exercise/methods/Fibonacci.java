package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amountOfFibonacci = 0;
		while (amountOfFibonacci < 1) {
			System.out.println("Wie viele Fibonacci-Zahlen berechnen?");
			amountOfFibonacci = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < amountOfFibonacci; i++) {
			System.out.println("F( " + i + ") = " + calculateFibonacci(i));
		}
	}

	public static long calculateFibonacci(int amountOfFibonacci) {
		if (amountOfFibonacci == 0) {
			return 0;
		} else if (amountOfFibonacci == 1) {
			return 1;
		} else {
			return calculateFibonacci(amountOfFibonacci - 1) + calculateFibonacci(amountOfFibonacci - 2);
		}
	}

}
