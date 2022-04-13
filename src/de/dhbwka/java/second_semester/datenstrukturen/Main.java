package de.dhbwka.java.second_semester.datenstrukturen;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
//		Lottery lottery = new Lottery();
//		lottery.print();

//		Library library = new Library();
//		library.start();

		BinaryTree<Integer> tree = new BinaryTree<>();
		System.out.println("isEmpty: " + tree.isEmpty());
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int n = rnd.nextInt(51);
			tree.add(n);
			System.out.println("Added: " + n);
		}
		System.out.println("isEmpty: " + tree.isEmpty());
		System.out.println("Sorted values: " + Arrays.toString(tree.traverse().toArray()));
	}

}
