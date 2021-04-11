package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Pascal {

	public static void main(String[] args) {
		System.out.println("Wie viele Zeilen sollen dargestellt werden?");
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		sc.close();
		int[][] pascalTriangle = new int[rows][];
		for (int i = 0; i < pascalTriangle.length; i++) {
			pascalTriangle[i] = new int[i + 1];
			for (int j = 0; j < pascalTriangle[i].length; j++) {
				if (j == 0 || j == pascalTriangle[i].length - 1) {
					pascalTriangle[i][j] = 1;
				} else {
					pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
				}
			}
		}
//		int lastRowLength = 0;
//		for (int rowLengthDeterminator = 0; rowLengthDeterminator < pascalTriangle[pascalTriangle.length - 1].length; rowLengthDeterminator++) {
//			lastRowLength += String.valueOf(pascalTriangle[pascalTriangle.length - 1][rowLengthDeterminator]).length();    
//		}
//		lastRowLength += (rows * 3) - 3;
		for (int i = 0; i < pascalTriangle.length; i++) {
//			int currentRowLength = 0;
//			for (int currentRowLengthDeterminator = 0; currentRowLengthDeterminator < pascalTriangle[i].length; currentRowLengthDeterminator++) {
//				currentRowLength += String.valueOf(pascalTriangle[i][currentRowLengthDeterminator]).length() + 3;				
//			}
//			currentRowLength -= 3;
//			for (int spaces = 0; spaces < lastRowLength - currentRowLength; spaces++) {
//				System.out.print(" ");
//			}
			for (int j = 0; j < pascalTriangle[i].length; j++) {
				System.out.print(pascalTriangle[i][j] + " ");
			}
			System.out.println();
		}
	}

}
