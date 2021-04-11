package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Wie ist dein Name?");
		String playerName = sc.next();
		boolean play = true;
		int numberToGuess = (int) (Math.random() * 100);
		while (play) {
			System.out.print(playerName + " , rate eine Zahl [1-100]: ");
			int guessedNumber = sc.nextInt();
			if (guessedNumber < numberToGuess) {
				System.out.println("Die zu erratende Zahl ist größer!");
			} else if (guessedNumber > numberToGuess) {
				System.out.println("Die zu erratende Zahl ist kleiner!");
			} else {
				System.out.println(guessedNumber + " ist korrekt.");
				System.out.println("Was möchtest du tun?");
				System.out.println("0 - Das Spiel beenden");
				System.out.println("1 - Das Spiel fortsetzen");
				int playingCondition = sc.nextInt();
				if (playingCondition == 0) {
					play = false;
				}
				numberToGuess = (int) (Math.random() * 100);
			}

		}
		sc.close();
	}

}
