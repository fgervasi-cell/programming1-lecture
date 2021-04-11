package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		System.out.println("Wie viele Zahlen soll das Array haben?");
		Scanner sc = new Scanner(System.in);
		int arrayLength = sc.nextInt();
		sc.close();
		int[] array = new int[arrayLength];
		Random random = new Random();
		for (int i = 0; i < arrayLength; i++) {
			array[i] = random.nextInt(101);
		}
		System.out.println("Unsortiertes Array: " + Arrays.toString(array));
		for (int i = 0; i < arrayLength; i++) {
			for (int j = i; j < arrayLength; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			
		}
		System.out.println("Sortiertes Array: " + Arrays.toString(array));
	}

}
