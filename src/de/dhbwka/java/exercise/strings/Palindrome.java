package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte ein Wort eingeben:");
		String potentialPalindrome = sc.next();
		sc.close();
		System.out.println("Umgekehrt: " + reverseString(potentialPalindrome));
		System.out.println(stringIsPalindrome(reverseString(potentialPalindrome), potentialPalindrome));
	}
	
	private static String reverseString(String potentialPalindrome) {
		StringBuilder builder = new StringBuilder();
		for (int i = potentialPalindrome.length() - 1; i >= 0; i--) {
			builder.append(potentialPalindrome.toCharArray()[i]);
		}
		return builder.toString();
	}
	
	private static String stringIsPalindrome(String reversedString, String potentialPalindrome) {
		if (reversedString.equalsIgnoreCase(potentialPalindrome)) {
			return potentialPalindrome + " ist ein Palindrom!";
		} else {
			return potentialPalindrome + " ist kein Palindrom!";
		}
	}
	
}
