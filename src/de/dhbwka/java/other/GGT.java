package de.dhbwka.java.other;

import java.util.Scanner;

public class GGT {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int a, b;
			System.out.println("Please enter the first number: ");
			a = sc.nextInt();
			System.out.println("Please enter the second number: ");
			b = sc.nextInt();
			while (a != b) {
				if (a > b) {
					a = a - b;
				}
				else {
					b = b - a;
				}
			}
			System.out.println(a);
		}
	}

}
