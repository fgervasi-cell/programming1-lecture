package de.dhbwka.java.exercise.control;

public class Deers {

	public static void main(String[] args) {
		int deer = 200, i = 1;
		while (deer < 300) {
			deer += deer * 0.1 - 15;
			System.out.print(i++ + ": ");
			System.out.println(deer + " Hirsche");
		}
	}
}
