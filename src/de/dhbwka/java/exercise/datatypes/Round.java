package de.dhbwka.java.exercise.datatypes;

public class Round {

	public static void main(String[] args) {
		double pi = 3.1415926;
		double e = 2.7182818;
		System.out.println("pi ~ " + round(pi));
		System.out.println("e ~ " + round(e));
		System.out.println("-pi ~ " + round(-pi));
		System.out.println("-e ~ " + round(-e));
		System.out.println("-3.213 ~ " + round(-3.213));
		System.out.println("3.213 ~ " + round(3.213));
	}

	static public double round(double number) {
		if (number >= 0) {
			if (number - (int) number >= 0.5) {
				return (int) ++number;

			} else {
				return (int) number;
			}
		}
		else {
			if (number + (int) -number <= -0.5) {
				return (int) --number;

			} else {
				return (int) number;
			}
		}
		
	}

}
