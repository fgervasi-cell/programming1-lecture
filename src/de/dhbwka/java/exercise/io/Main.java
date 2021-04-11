package de.dhbwka.java.exercise.io;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		TextFile textFile = new TextFile("bla.txt");
		System.out.println(textFile.availableLines());
		System.out.println(Arrays.toString(textFile.getLines()));
		try {
			System.out.println(textFile.getLine(1));
		} catch (LineNumberOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

	}

}
