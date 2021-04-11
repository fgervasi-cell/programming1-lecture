package de.dhbwka.java.exercise.arrays;

import java.util.Random;
import java.util.Scanner;

public class MatrixSubtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte Anzahl Zeilen eingeben: ");
		int rows = sc.nextInt();
		System.out.println("Bitte Anzahl Spalten eingeben: ");
		int columns = sc.nextInt();
		sc.close();
		Random rnd = new Random();
		int[][] matrixX = new int[rows][columns];
		int[][] matrixY = new int[rows][columns];
		for (int i = 0; i < matrixX.length; i++) {
			for (int j = 0; j < matrixX[i].length; j++) {
				matrixX[i][j] = rnd.nextInt(100);
			}
		}
		for (int i = 0; i < matrixY.length; i++) {
			for (int j = 0; j < matrixY[i].length; j++) {
				matrixY[i][j] = rnd.nextInt(100);
			}
		}
		int[][] subtractionMatrix = new int[rows][columns];
		for (int i = 0; i < subtractionMatrix.length; i++) {
			for (int j = 0; j < subtractionMatrix[i].length; j++) {
				subtractionMatrix[i][j] = matrixX[i][j] - matrixY[i][j];
			}
		}
		System.out.println("X:");
		for (int i = 0; i < matrixX.length; i++) {
			for (int j = 0; j < matrixX[i].length; j++) {
				for (int spaces = 0; spaces <= 3 - String.valueOf(matrixX[i][j]).length(); spaces++) {
					System.out.print(" ");
				}
				System.out.print(matrixX[i][j]);		
			}
			System.out.println();
		}
		System.out.println("Y:");
		for (int i = 0; i < matrixY.length; i++) {
			for (int j = 0; j < matrixY[i].length; j++) {
				for (int spaces = 0; spaces <= 3 - String.valueOf(matrixY[i][j]).length(); spaces++) {
					System.out.print(" ");
				}
				System.out.print(matrixY[i][j]);	
			}
			System.out.println();
		}
		System.out.println("X-Y:");
		for (int i = 0; i < subtractionMatrix.length; i++) {
			for (int j = 0; j < subtractionMatrix[i].length; j++) {
				for (int spaces = 0; spaces <= 3 - String.valueOf(subtractionMatrix[i][j]).length(); spaces++) {
					System.out.print(" ");
				}
				System.out.print(subtractionMatrix[i][j]);		
			}
			System.out.println();
		}
	}
	
}
