package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;

public class FileExperiments {

	public static void main(String[] args) {
		File myDir = new File("myDir");
		myDir.mkdir();
		File foo1 = new File(myDir, "foo1.txt");
		File foo2 = new File(myDir, "foo2.txt");
		File foo3 = new File(myDir, "foo3.txt");
		try {
			foo1.createNewFile();
			foo2.createNewFile();
			foo3.createNewFile();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(myDir.getAbsolutePath());
		for (File file : myDir.listFiles()) {
			System.out.println(file.getName());
		}
		foo1.deleteOnExit();
		foo2.deleteOnExit();
		foo3.deleteOnExit();
		myDir.deleteOnExit();
	}

}
