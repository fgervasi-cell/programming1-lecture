package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class CrossTotal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte Zahl für Quersumme eingeben:");
		String number = sc.next();
		sc.close();
		System.out.println(calculateCheckSum(number));
	}

	private static String calculateCheckSum(String number) {
		int checkSum = 0;
		for (int i = 0; i < number.length(); i++) {
			checkSum += Integer.parseInt(String.valueOf(number.charAt(i)));
		}
		return "Die Quersumme von " + number + " ist " + checkSum;
	}
}
