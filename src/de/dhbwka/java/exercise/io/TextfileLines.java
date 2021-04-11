package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class TextfileLines {

	public static void main(String[] args) {
		File file = new File("beispiel.txt");
		StringBuilder builder = new StringBuilder();
		try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
			while (lineNumberReader.ready()) {
				String line = lineNumberReader.readLine();
				if (lineNumberReader.getLineNumber() >= 2 && lineNumberReader.getLineNumber() <= 5) {
					System.out.println(line);
					builder.append(line);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Zeile 2-5: " + builder.toString());
	}

}
