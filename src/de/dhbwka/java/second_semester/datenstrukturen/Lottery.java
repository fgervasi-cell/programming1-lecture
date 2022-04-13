package de.dhbwka.java.second_semester.datenstrukturen;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
	private static final int AMOUNT_OF_LOTTERY_NUMBERS = 7;
	private final Set<Integer> lotteryNumbers = new TreeSet<>();
	private Random rnd;
	public Lottery() {
		rnd = new Random();
		while(lotteryNumbers.size() < AMOUNT_OF_LOTTERY_NUMBERS) {
			lotteryNumbers.add(rnd.nextInt(49)+1);
		}
	}
	
	public void print() {
		System.out.print(lotteryNumbers);
		System.out.println(" Zusatzzahl: " + (rnd.nextInt(49)+1));
	}
}
