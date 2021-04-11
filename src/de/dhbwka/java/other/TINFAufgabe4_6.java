package de.dhbwka.java.other;

import java.util.Arrays;

public class TINFAufgabe4_6 {

	public static void main(String[] args) {
//		System.out.println("How many variables?");
//		Scanner sc = new Scanner(System.in);
		double variablesCount = 7 /* sc.nextDouble() */;
		String[] variableNames = { "G", "A", "F", "S", "K", "V", "D" } /* new String[(int) variablesCount] */;
//		for (int i = 0; i < variablesCount; i++) {
//			System.out.print("Variable name " + i + ":");
//			variableNames[i] = sc.next();
//		}
//		sc.close();
		boolean[][] table = new boolean[(int) Math.pow(2.0, variablesCount)][(int) variablesCount];
		for (int i = 0; i < table.length; i++) {
			if (i > 0) {
				System.arraycopy(table[i - 1], 0, table[i], 0, (int) variablesCount);
				boolean isMatching = true;
				int counter = 1;
				while (isMatching) {
					table[i][table[i].length - counter] = !table[i - 1][table[i].length - counter];
					for (int rowIndex = i - 1; rowIndex >= 0; rowIndex--) {
						if (Arrays.equals(table[rowIndex], table[i])) {
							table[i][table[i].length - counter] = !table[i][table[i].length - counter];
							counter++;
							break;
						} else if (rowIndex == 0) {
							isMatching = false;
						}
					}
				}
			}
		}
		for (int variableNameIndex = 0; variableNameIndex < variableNames.length; variableNameIndex++) {
			for (int spaces = 0; spaces < 6; spaces++) {
				System.out.print(" ");
			}
			System.out.print(variableNames[variableNameIndex]);
		}
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			if (i + 1 < 10) {
				System.out.print(" ");
			}
			if (i + 1 < 100) {
				System.out.print(" ");
			}
			System.out.print((i + 1) + ". |");
			for (int j = 0; j < table[i].length; j++) {

				System.out.print(table[i][j]);
				if (table[i][j] == true) {

					System.out.print(" ");

					System.out.print(" |");
				} else {
					System.out.print(" |");
				}

			}
			System.out.println();
		}

		for (int i = 0; i < table.length; i++) {

			if ((!table[i][1] || !table[i][2]) && (!table[i][0] || table[i][1]) && (table[i][0] || table[i][2])
					&& (!table[i][1] || table[i][3]) && (!table[i][2] || table[i][4]) && (!table[i][5])
					&& (!table[i][6]) && (!(!table[i][0] && (!table[i][5] && !table[i][6])))) {
				System.out.println("Belegsfunktion gefunden!");
				System.out.print("G: " + table[i][0] + " ");
				System.out.print("A: " + table[i][1] + " ");
				System.out.print("F: " + table[i][2] + " ");
				System.out.print("S: " + table[i][3] + " ");
				System.out.print("K: " + table[i][4] + " ");
				System.out.print("V: " + table[i][5] + " ");
				System.out.print("D: " + table[i][6] + " ");
				System.out.println();

			}
		}
	}

}
