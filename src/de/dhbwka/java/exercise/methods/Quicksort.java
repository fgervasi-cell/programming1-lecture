package de.dhbwka.java.exercise.methods;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {

	private static int[] randomArray;
	
	public static void main(String[] args) {
		Random random = new Random();
		randomArray = new int[20];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(1000);
		}
		System.out.println("Unsortiertes Array:");
		System.out.println(Arrays.toString(randomArray));
		System.out.println("Sortiertes Array:");
		sort(0, randomArray.length - 1);
		System.out.println(Arrays.toString(randomArray));
	}
	
	public static void sort(int links, int rechts) {
		if (links < rechts) {
			int teiler = teile(links, rechts);
			sort(links, teiler - 1);
			sort(teiler + 1, rechts);
		}
	}
	
	
	private static int teile(int links, int rechts) {
		int i = links;
		int j = rechts - 1;
		int pivot = randomArray[rechts];
		while(i < j) {
			while (randomArray[i] <= pivot && i < rechts) {
				i++;
			}
			while (randomArray[j] >= pivot && j > links) {
				j--;
			}
			if (i < j) {
				int temp = randomArray[i];
				randomArray[i] = randomArray[j];
				randomArray[j] = temp;
			}
		}
		if (randomArray[i] > pivot) {
			int temp = randomArray[i];
			randomArray[i] = randomArray[rechts];
			randomArray[rechts] = temp;
		}
		return i;
	}

}
