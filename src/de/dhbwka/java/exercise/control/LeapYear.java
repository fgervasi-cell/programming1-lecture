package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welches Schaltjahr soll geprüft werden?");
			int leapYear = sc.nextInt();
			if (leapYear % 4 == 0) {
				if (leapYear % 100 == 0 && leapYear % 400 != 0) {
					System.out.println(leapYear + " ist kein Schaltjahr");
				} else if (leapYear % 100 == 0 && leapYear % 400 == 0) {
					System.out.println(leapYear + " ist ein Schaltjahr");
				} else {
					System.out.println(leapYear + " ist ein Schaltjahr");
				}
			} else {
				System.out.println(leapYear + " ist kein Schaltjahr");
			}

		}

	}

}
