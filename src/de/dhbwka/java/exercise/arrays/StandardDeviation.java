package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Random;

public class StandardDeviation {

	public static void main(String[] args) {
		int[] numbers = new int[100];
		Random random = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(11);
		}
		double average = 0;
		double standardDeviation = 0;
		for (int number : numbers) {
			average += number;
		}
		average /= numbers.length;
		for (int number : numbers) {
			standardDeviation += Math.pow(number - average, 2);
		}
		standardDeviation = standardDeviation * (1.0 / (numbers.length - 1));
		standardDeviation = Math.sqrt(standardDeviation);
		System.out.println(Arrays.toString(numbers));
		System.out.println("Mittelwert: " + average);
		System.out.println("Standardabweichung: " + standardDeviation);
	}

}
