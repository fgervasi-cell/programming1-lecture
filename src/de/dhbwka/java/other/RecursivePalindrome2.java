package de.dhbwka.java.other;

public class RecursivePalindrome2 {

	public static void main(String[] args) {
		System.out.println(isPalindrome("ABBA"));
		System.out.println(isPalindrome("abba"));
		System.out.println(isPalindrome("Lagerregal"));
		System.out.println(isPalindrome("ABBAA"));
		System.out.println(isPalindrome("felix"));
	}

	private static boolean isPalindrome(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return true;
		} else if (s.toLowerCase().charAt(0) == s.toLowerCase().charAt(s.length() - 1)) {
			return isPalindrome(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}

}
