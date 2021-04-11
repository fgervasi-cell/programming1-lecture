package de.dhbwka.java.exercise.classes.complex;

public class Main {

	public static void main(String[] args) {
		int counterForComps = 0;
		Complex[] complexArray = Complex.random(10);
		System.out.println("C0 + C1: " + Complex.add(complexArray[0], complexArray[1]));
		System.out.println("C3 + C7: " + Complex.add(complexArray[3], complexArray[7]));
		System.out.println("C3 - C7: " + Complex.sub(complexArray[3], complexArray[7]));
		System.out.println("C0 * C1: " + Complex.mult(complexArray[0], complexArray[1]));
		System.out.println("C9 / C5: " + Complex.div(complexArray[9], complexArray[5]));
		System.out.println("Unsortiert:");
		for (Complex comp : complexArray) {
			System.out.println("C" + counterForComps++ + ": " + comp);
		}
		System.out.println("Sortiert:");
		Complex[] sortedComplexArray = complexArray;
		for (int i = 0; i < sortedComplexArray.length; i++) {
				for (int j = i; j < sortedComplexArray.length; j++) {
					if (Complex.isLess(sortedComplexArray[i], sortedComplexArray[j])) {
						Complex temp = sortedComplexArray[i];
						sortedComplexArray[i] = sortedComplexArray[j];
						sortedComplexArray[j] = temp;
					}
				}
		}
		for (Complex comp : sortedComplexArray) {
			System.out.println(comp + " Betrag: " + comp.getMagnitude());
		}
	}
}
