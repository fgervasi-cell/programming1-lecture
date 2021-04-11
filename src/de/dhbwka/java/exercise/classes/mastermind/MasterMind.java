package de.dhbwka.java.exercise.classes.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {

	private char[] arrayOfLettersToBeGuessed;
	private List<String> history;
	private boolean guessedCorrect;

	public MasterMind() {
		arrayOfLettersToBeGuessed = new char[5];
		history = new ArrayList<>();
		guessedCorrect = false;
	}

	public void startGame() {
		init();
		keepGameRunning();
	}

	private void init() {
		Random random = new Random();
		for (int i = 0; i < arrayOfLettersToBeGuessed.length; i++) {
			arrayOfLettersToBeGuessed[i] = (char) (random.nextInt(7) + 65);
		}
	}

	private void keepGameRunning() {
		Scanner sc = new Scanner(System.in);
		int amountOfGuesses = 1;
		String tip;
		while (amountOfGuesses <= 20 && !guessedCorrect) {
			System.out.println("Geben Sie Ihren Tipp ab: ");
//			tip = sc.next();
			tip = new String(makeRandomGuesses());
			checkTip(tip);
			createResponse(amountOfGuesses++);
			if (guessedCorrect) {
				System.out.println("Mit " + amountOfGuesses + " Versuchen gewonnen!");
			}
			if (amountOfGuesses == 21) {
				System.out.println("Keine Versuche mehr übrig!");
			}
		}
		sc.close();
	}

	private void createResponse(int amountOfGuesses) {
		System.out.println(amountOfGuesses + " bisherige Versuche:");
		for (int i = 0; i < history.size(); i++) {
			System.out.println(history.get(i));
		}
	}

	private int[] checkTip(String tip) {
		int correctGuessesTotal = 0;
		int correctGuessesOnPosition = 0;
		for (int i = 0; i < tip.length(); i++) {
			for (int j = 0; j < arrayOfLettersToBeGuessed.length; j++) {
				if (tip.toUpperCase().toCharArray()[i] == arrayOfLettersToBeGuessed[j]) {
					if (i == j) {
						correctGuessesOnPosition++;
						correctGuessesTotal++;
					} else {
						correctGuessesTotal++;
					}
				}
			}
		}
		if (correctGuessesOnPosition == arrayOfLettersToBeGuessed.length) {
			guessedCorrect = true;
		}
		String historyElement = tip.toUpperCase() + " " + correctGuessesTotal + " " + correctGuessesOnPosition;
		history.add(historyElement);
		int[] checkTipResultsArray = new int[2];
		checkTipResultsArray[0] = correctGuessesTotal;
		checkTipResultsArray[1] = correctGuessesOnPosition;
		return checkTipResultsArray;
	}
	
	private char[] makeRandomGuesses() {
		Random random = new Random();
		char[] randomGuess = new char[5];
		for (int i = 0; i < randomGuess.length; i++) {
			randomGuess[i] = (char) (random.nextInt(7) + 65);
		}
		return randomGuess;
	}

}
