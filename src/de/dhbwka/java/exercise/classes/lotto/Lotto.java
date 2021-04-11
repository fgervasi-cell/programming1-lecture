package de.dhbwka.java.exercise.classes.lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int ballsToDraw;
	private int totalBalls;
	private int[] tip;
	private int[] drawnNumbers;
	private boolean hasDrawn;
	private boolean hasGuessed;

	public Lotto(int ballsToDraw, int totalBalls) {
		this.ballsToDraw = ballsToDraw;
		this.totalBalls = totalBalls;
		this.tip = new int[ballsToDraw];
		this.drawnNumbers = new int[ballsToDraw];
		this.hasDrawn = false;
		this.hasGuessed = false;
	}
	
	public void makeTip() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < ballsToDraw; i++) {
			System.out.print("Make your " + i + ". tip: ");
			tip[i] = sc.nextInt();
			while (tip[i] < 0 || tip[i] > totalBalls) {
				System.out.println("Invalid tip! Make another guess.");
				tip[i] = sc.nextInt();
			}
		}
		System.out.println("Tip: " + Arrays.toString(sortArray(tip)));
		this.hasGuessed = true;
		sc.close();
	}
	
	public void makeTip(int[] tip) {
		if (tipIsValid()) {
			this.tip = tip;
			this.hasGuessed = true;
		} else {
			System.out.println("Your tip is invalid!");
		}
	}
	
	public String draw() {
		Random random = new Random();
		for (int i = 0; i < drawnNumbers.length; i++) {
			drawnNumbers[i] = random.nextInt(totalBalls + 1);
		}
		this.hasDrawn = true;
		return Arrays.toString(sortArray(drawnNumbers));
	}
	
	public int correctTips() {
		int correctTipsCounter = 0;
		for (int i = 0; i < ballsToDraw; i++) {
			for (int j = 0; j < ballsToDraw; j++) {
				if (tip[i] == drawnNumbers[j]) {
					correctTipsCounter++;
				}
			}
		
		}
		return correctTipsCounter;
	}
	
	private int[] sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	@Override
	public String toString() {
		if (!hasGuessed && !hasDrawn) {
			return "You did not guess or make a draw!";
		} else if (!hasGuessed && hasDrawn) {
			return String.format("Drawing: %s",  Arrays.toString(sortArray(drawnNumbers)));
		} else if (hasGuessed && !hasDrawn) {
			return String.format("Tip: %s", Arrays.toString(sortArray(tip)));
		} else {
			return String.format("Tip: %s%nDrawing: %s%nCorrect guesses: %d", Arrays.toString(sortArray(tip)), Arrays.toString(sortArray(drawnNumbers)), correctTips());
		}
	}
	
	private boolean tipIsValid() {
		for (int guessedNumber : tip) {
			if (guessedNumber > totalBalls || guessedNumber < 0) {
				return false;
			}
		}
		return true;
	}

	public int getBallsToDraw() {
		return ballsToDraw;
	}

	public int getTotalBalls() {
		return totalBalls;
	}

	public int[] getTip() {
		return sortArray(tip);
	}

	public int[] getDrawnNumbers() {
		return drawnNumbers;
	}
}
