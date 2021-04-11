package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class RomanNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine römische Zahl ein:");
		String romanNumber = sc.next();
		sc.close();
		System.out.println("Der Wert der Zahl " + romanNumber + " ist " + translateIntoDecimal(romanNumber));
	}

	private static int translateIntoDecimal(String romanNumber) {
		int decimal = 0;
		for (int i = 0; i < romanNumber.length(); i++) {
			if (romanNumber.toUpperCase().toCharArray()[i] == 'I') {
				decimal += i != romanNumber.length() - 1 ? determineIfPositiveOrNegative(1, romanNumber.toUpperCase().toCharArray()[i + 1]) : 1;
			} else if (romanNumber.toUpperCase().toCharArray()[i] == 'V') {
				decimal += i != romanNumber.length() - 1 ? determineIfPositiveOrNegative(5, romanNumber.toUpperCase().toCharArray()[i + 1]) : 5;
			} else if (romanNumber.toUpperCase().toCharArray()[i] == 'X') {
				decimal += i != romanNumber.length() - 1 ? determineIfPositiveOrNegative(10, romanNumber.toUpperCase().toCharArray()[i + 1]) : 10;
			} else if (romanNumber.toUpperCase().toCharArray()[i] == 'L') {
				decimal += i != romanNumber.length() - 1 ? determineIfPositiveOrNegative(50, romanNumber.toUpperCase().toCharArray()[i + 1]) : 50;
			} else if (romanNumber.toUpperCase().toCharArray()[i] == 'C') {
				decimal += i != romanNumber.length() - 1 ? determineIfPositiveOrNegative(100, romanNumber.toUpperCase().toCharArray()[i + 1]) : 100;
			} else if (romanNumber.toUpperCase().toCharArray()[i] == 'D') {
				decimal += i != romanNumber.length() - 1 ? determineIfPositiveOrNegative(500, romanNumber.toUpperCase().toCharArray()[i + 1]) : 500;
			} else {
				decimal += i != romanNumber.length() - 1 ? determineIfPositiveOrNegative(1000, romanNumber.toUpperCase().toCharArray()[i + 1]) : 1000;
			}
		}
		return decimal;
	}

	private static int determineIfPositiveOrNegative(int value, char nextNumeral) {
		char[] romanNumerals = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int index;
		if (value == 1) {
			index = 1;
		} else if (value == 5) {
			index = 2;
		} else if (value == 10) {
			index = 3;
		} else if (value == 50) {
			index = 4;
		} else if (value == 100) {
			index = 5;
		} else if (value == 500) {
			index = 6;
		} else {
			index = 7;
		}
		for (int i = index; i < romanNumerals.length; i++) {
			if (nextNumeral == romanNumerals[i]) {
				return -value;
			}
		}
		return value;
	}

}
