package de.dhbwka.java.other;

public class Pell {

	public static void main(String[] args) {
		System.out.println(recursivePell(6));
		System.out.println(iterativePell(6));
	}

	private static int recursivePell(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return 2 * recursivePell(n - 1) + recursivePell(n - 2);
		}
	}

	private static int iterativePell(int n) {
		int aZero = 2;
		int aOne = 1;
		int aTwo = 0;
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		}
		for (int i = 2; i <= n; i++) {
			aZero = 2 * aOne + aTwo;
			aTwo = aOne;
			aOne = aZero;
		}
		return aZero;
	}

}
