package de.dhbwka.java.exercise.classes.periodic;

public class Main {

	public static void main(String[] args) {
		PeriodicTable periodicTable = new PeriodicTable();
		periodicTable.addElement(new Element("H", "Wasserstoff", 1, 'K', 3, true));
		periodicTable.addElement(new Element("He", "Helium", 2, 'K', 3, true));
		periodicTable.addElement(new Metal("Na", "Natrium", 11, 'M', 1, true, false, 21 * Math.pow(10, 6)));
		periodicTable.addElement(new Metal("Fe", "Eisen", 26, 'N', 1, true, false, 10.02 * Math.pow(10, 6)));
		periodicTable.addElement(new Metal("Ge", "Germanium", 32, 'N', 1, false, true, 1.45));
		periodicTable.addElement(new Element("Br", "Brom", 35, 'N', 2, false));
		periodicTable.addElement(new Metal("Te", "Tellur", 52, 'O', 1, true, true, 0.005));
		periodicTable.addElement(new Metal("Au", "Gold", 79, 'P', 1, false, false, 44.0 * Math.pow(10, 6)));
		System.out.println("Alle gespeicherten Elemente:");
		for (int i = 0; i < periodicTable.getElements().length; i++) {
			System.out.println(periodicTable.getElements()[i]);
		}
		System.out.println();
		System.out.println("Metalle:");
		for (Element e : periodicTable.getMetals()) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println("Gold:");
		System.out.println(periodicTable.getElement(79));
	}

}
