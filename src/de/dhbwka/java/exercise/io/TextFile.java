package de.dhbwka.java.exercise.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class TextFile {
	private File f;
	private List<String> lines = new ArrayList<>();

	public TextFile(File f) {
		if (f.exists()) {
			this.f = f;
			read();
		}
	}

	public TextFile(String pathname) {
		File temp = new File(pathname);
		if (temp.exists()) {
			this.f = temp;
			read();
		}
	}

	public void read() {
		lines.clear();
		try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(this.f))) {
			while (lineNumberReader.ready()) {
				lines.add(lineNumberReader.readLine());
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void write() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.f))) {
			for (int i = 0; i < availableLines(); i++) {
				bufferedWriter.append(lines.get(i));
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public int availableLines() {
		try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(this.f))) {
			int availableLines = 0;
			while (lineNumberReader.ready()) {
				lineNumberReader.readLine();
				availableLines = lineNumberReader.getLineNumber();
			}
			return availableLines;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return -1;
		}
	}

	public String[] getLines() {
		String[] tmpLines = new String[lines.size()];
		for(int i = 0; i < lines.size(); i++) {
			tmpLines[i] = lines.get(i);
		}
		return tmpLines;
	}

	public String getLine(int i) throws LineNumberOutOfBoundsException {
		if (i < 1 || i > lines.size()) {
			throw new LineNumberOutOfBoundsException("Enter a number greater than 0!");
		}
		return lines.get(i - 1);
	}

	public void setLine(int i, String s) {

	}

	public void replaceAll(String regexp, String ersatz) {

	}

	public void close() {
		lines.clear();
		this.f = null;
	}
}
