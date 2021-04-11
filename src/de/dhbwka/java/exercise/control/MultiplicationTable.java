package de.dhbwka.java.exercise.control;

public class MultiplicationTable {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int factor2 = 1; factor2 <= 10; factor2++) {
				for (int spaces = 0; spaces < 4 - String.valueOf(i * factor2).length(); spaces++) {
					System.out.print(" ");
				}
				System.out.print(i * factor2);
			}
			System.out.println();
		}

	}

}
