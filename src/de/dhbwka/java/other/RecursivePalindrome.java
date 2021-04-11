package de.dhbwka.java.other;

public class RecursivePalindrome {

	public static void main(String[] args) {
		System.out.println(checkForPalindrome("Lagerregal"));
		System.out.println(checkForPalindrome("Otto"));
		System.out.println(checkForPalindrome("EinEselLeseNie"));
		System.out.println(checkForPalindrome("Felix"));
		System.out.println(checkForPalindrome("Robert"));
		System.out.println(checkForPalindrome("Horner"));
	}
	
	public static boolean checkForPalindrome(String s) {
		if(s.length() == 0 || s.length() == 1) {
			return true;
		} else if(s.toLowerCase().charAt(0) == s.toLowerCase().charAt(s.length() - 1)) {
			return checkForPalindrome(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}

}
