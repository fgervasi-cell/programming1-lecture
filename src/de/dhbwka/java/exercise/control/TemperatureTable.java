package de.dhbwka.java.exercise.control;

public class TemperatureTable {

	public static void main(String[] args) {
		System.out.print("Fahrenheit |");
		System.out.println(" Celsius");
		for (int i = 0; i < 20; i++) {
			if (i == 11) {
				System.out.print('+');
			} else {
				System.out.print('-');
			}
		}
		System.out.println();
		for (int temperatureIndex = 0; temperatureIndex < 301; temperatureIndex += 20) {
			for (int spacesIndex = 0; spacesIndex < 3 - String.valueOf(temperatureIndex).length(); spacesIndex++) {
				System.out.print(" ");
			}
			System.out.print(temperatureIndex);
			for (int spacesIndex2 = 0; spacesIndex2 < 8; spacesIndex2++) {
				System.out.print(" ");
				
			}
			System.out.print("|");
			double c = (5.0/9.0)*(temperatureIndex-32);
			System.out.println(" " + c);
		}

	}

}
