package de.dhbwka.java.exercise.control;

public class ShoeSize {

	public static void main(String[] args) {
		System.out.print("Zentimeter");
		for (int i = 0; i < 13 - "Zentimeter".length(); i++) {
			System.out.print(" ");
		}
		System.out.print("|");
		System.out.println("Größe");
		for (int tableHeaderIndex = 0; tableHeaderIndex < 13; tableHeaderIndex++) {
			System.out.print("-");
		}
		System.out.print("+");
		for (int tableHeaderIndex2 = 0; tableHeaderIndex2 < "Größe".length(); tableHeaderIndex2++)
		{
			System.out.print("-");
		}
		System.out.println();
		double shoeSizeCentimeters = 19.33;
		for (int i = 0; i < 20; i++) {
			System.out.printf("%.2f", shoeSizeCentimeters);
			System.out.print(" - ");
			System.out.printf("%.2f", (shoeSizeCentimeters + 0.67));
			System.out.print("|");
			System.out.println(Math.round((shoeSizeCentimeters + 0.67) * 1.5));
			shoeSizeCentimeters += 0.67;
		}

	}

}
