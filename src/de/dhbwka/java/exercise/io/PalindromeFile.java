package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PalindromeFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Exit with x!");
		File palindromesFile = new File("palindromes.txt");
		while (true) {
			System.out.println("Bitte ein Wort eingeben:");
			String potentialPalindrome = sc.next();
			if (potentialPalindrome.equals("x")) {
				break;
			}
			System.out.println("Umgekehrt: " + reverseString(potentialPalindrome));
			System.out.println(stringIsPalindrome(reverseString(potentialPalindrome), potentialPalindrome));
			try (PrintWriter printWriter = new PrintWriter(new FileWriter(palindromesFile, true))) {
				if (!palindromesFile.exists()) {
					palindromesFile.createNewFile();
				}
				printWriter.println(stringIsPalindrome(reverseString(potentialPalindrome), potentialPalindrome));
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Bisher gefundene Palindrome:");
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(palindromesFile))) {
				while (bufferedReader.ready()) {
					System.out.println(bufferedReader.readLine());
				}
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		sc.close();
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
