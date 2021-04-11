package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.print("Wie viele Fibonacci-Zahlen sollen berechnet werden?");
		Scanner sc = new Scanner(System.in);
		int amountOfFibonacciNumbers = sc.nextInt();
		sc.close();
		int[] fibonacciNumbers = new int[amountOfFibonacciNumbers];
		fibonacciNumbers[0] = 1;
		fibonacciNumbers[1] = 1;
		for (int i = 2; i < fibonacciNumbers.length; i++) {
			fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
		}
		for (int i = 0; i < fibonacciNumbers.length; i++) {
			System.out.println("f" + i + ": " + fibonacciNumbers[i]);
		}

	}

}
