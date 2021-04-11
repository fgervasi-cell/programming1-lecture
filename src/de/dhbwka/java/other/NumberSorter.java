package de.dhbwka.java.other;

import java.util.ArrayList;
import java.util.List;

public class NumberSorter {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add((int) (Math.random() * 1000));
		numbers.add((int) (Math.random() * 1000));
		numbers.add((int) (Math.random() * 1000));
		numbers.add((int) (Math.random() * 1000));
		numbers.add((int) (Math.random() * 1000));
		numbers.add((int) (Math.random() * 1000));
		numbers.add((int) (Math.random() * 1000));
		numbers.add((int) (Math.random() * 1000));
		System.out.println(numbers.toString());
		System.out.println(sort(numbers));
	}

	private static String sort(List<Integer> numbers) {
		for (int i = 0; i < numbers.size() - 1; i++) {
			for (int inner = 0; inner < numbers.size() - 1; inner++) {
				if (numbers.get(inner) > numbers.get(inner + 1)) {
					numbers.add(inner, numbers.get(inner + 1));
					numbers.remove(inner + 2);
				}
			}
		}
		return numbers.toString();
	}

}
