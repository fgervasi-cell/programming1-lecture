package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Eratostenes {

	public static void main(String[] args) {
		System.out.println("Bis zu welcher Grenze sollen Primzahlen ermittelt werden?"); //ask user to choose array length
		Scanner sc = new Scanner(System.in);
		int topLevelBorder = sc.nextInt(); //read array length
		sc.close();
		int [] sieve = new int[topLevelBorder - 1]; //initialize sieve
		int [] primes = new int[topLevelBorder - 1]; //initialize field for prime numbers
		int counter = 0;
		for (int i = 2; i <= topLevelBorder; i++) { //fill sieve with numbers between 2 and array length
			sieve[counter++] = i;
		}
		int primeCounter = 0;
		while (sieve.length != 0) {
			int min = sieve[0]; //set the minimum to the first item in the array
//			for (int i = 0; i < sieve.length; i++) { //go through the sieve and find minimum value
//				if (sieve[i] < min) {
//					min = sieve[i];
//				}
//			}
			primes[primeCounter++] = min;
			int[] tempArray = new int[topLevelBorder - 1];
			int counter2 = 0;
			int sieveCounter = 0;
			for (int i = 0; i < sieve.length; i++) {
				if (sieve[sieveCounter] % min != 0) {
					tempArray[counter2++] = sieve[i];
				}
				sieveCounter++;
			}
			int countZeros = 0;
			for (int number : tempArray) {
				if (number == 0) {
					countZeros++;
				}
			}
			int[] tempArray2 = new int[tempArray.length - countZeros];
			System.arraycopy(tempArray, 0, tempArray2, 0, tempArray2.length);
			sieve = tempArray2;
		}
		int zeroCounter2 = 0;
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] == 0) {
				zeroCounter2++;
			}
		}
		int [] finallyFinished = new int[primes.length - zeroCounter2];
		System.arraycopy(primes, 0, finallyFinished, 0, finallyFinished.length);
		System.out.println("Primzahlen bis " + topLevelBorder +": " + Arrays.toString(finallyFinished));

	}

}
