package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class CrossTotalFile {

	public static void main(String[] args) {
		boolean isRunning = true;
		File crosstotalsFile = new File("crosstotals.txt");
		if (!crosstotalsFile.exists()) {
			try {
				crosstotalsFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Exit with x!");
		while (isRunning) {
			System.out.println("Bitte Zahl für Quersumme eingeben:");
			String number = sc.next();
			if (number.equals("x")) {
				isRunning = false;
				break;
			}
			System.out.println(calculateCheckSum(number));
			try (Writer writer = new FileWriter(crosstotalsFile, true)) {
				writer.write(String.format("Quersumme von %s ist %s%n", number, calculateCheckSum(number)));
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		sc.close();
	}

	private static String calculateCheckSum(String number) {
		int checkSum = 0;
		for (int i = 0; i < number.length(); i++) {
			checkSum += Integer.parseInt(String.valueOf(number.charAt(i)));
		}
		return "Die Quersumme von " + number + " ist " + checkSum;

	}

}
