package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Babylon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Wurzel aus welcher Zahl ziehen? ");
		double inputNumber = sc.nextInt();
		double startValue = 1;
		System.out.println("x1: " + startValue);
		double result = (startValue + (inputNumber / startValue)) / 2;
		System.out.println("x2: " + result);
		int index = 3;
		while (true) {
			startValue = result;
			result = (startValue + (inputNumber / startValue)) / 2;
			System.out.println("x" + index++ + ": " + result);
			if (Math.abs(result - startValue ) < Math.pow(10, -6)) {
				break;
			}
		}
		System.out.print("Die Wurzel aus " + inputNumber + " ist " + result);
		sc.close();
	}

}
