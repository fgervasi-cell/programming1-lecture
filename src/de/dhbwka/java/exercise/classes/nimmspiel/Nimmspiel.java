package de.dhbwka.java.exercise.classes.nimmspiel;

import java.util.Random;
import java.util.Scanner;

public class Nimmspiel {
	private String player1;
	private String player2;
	private int heap1;
	private int heap2;
	private int turn;
	private boolean gameIsRunning;

	public Nimmspiel(String player1, String player2) {
		Random random = new Random();
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setHeap1(random.nextInt(10) + 1);
		this.setHeap2(random.nextInt(10) + 1);
		this.gameIsRunning = false;
		this.turn = 0;
	}

	public void startGame() {
		Scanner sc = new Scanner(System.in);
		int drawnBalls;
		int heapSelected;
		gameIsRunning = true;
		while (gameIsRunning) {
			System.out.println("Spieler: " + this.player1 + " und " + this.player2 + ", Haufen 1: " + this.heap1
					+ " Kugel(n), Haufen 2: " + this.heap2 + " Kugel(n)");
			if (turn % 2 == 0) {
				System.out.print("Spieler " + player1 + ": Von welchem Haufen ziehen Sie? ");
				heapSelected = sc.nextInt();
				heapSelected = checkForValidHeap(sc, heapSelected);
				System.out.print("Spieler " + player1 + ": Wieviele Kugeln ziehen Sie? ");
				drawnBalls = sc.nextInt();
				validate(sc, drawnBalls, heapSelected);
				turn++;
			} else {
				System.out.print("Spieler " + player2 + ": Von welchem Haufen ziehen Sie? ");
				heapSelected = sc.nextInt();
				heapSelected = checkForValidHeap(sc, heapSelected);
				System.out.print("Spieler " + player2 + ": Wieviele Kugeln ziehen Sie? ");
				drawnBalls = sc.nextInt();
				validate(sc, drawnBalls, heapSelected);
				turn++;
			}
		}
		sc.close();
	}

	private void validate(Scanner sc, int drawnBalls, int heapSelected) {

		checkForValidDrawing(sc, drawnBalls, heapSelected);

		checkForWinningCondition(turn);

	}

	private void checkForValidDrawing(Scanner sc, int drawnBalls, int heapSelected) {
		if (heapSelected == 1) {
			while (heap1 - drawnBalls < 0 || drawnBalls <= 0) {

				System.out.println("Sie können nicht mehr Kugeln ziehen als der Haufen beinhaltet!");
				System.out.println("Wie viele Kuglen ziehen Sie?");
				drawnBalls = sc.nextInt();

			}
			heap1 -= drawnBalls;
		} else {
			while (heap2 - drawnBalls < 0 || drawnBalls <= 0) {

				System.out.println("Sie können nicht mehr Kugeln ziehen als der Haufen beinhaltet!");
				System.out.println("Wie viele Kuglen ziehen Sie?");
				drawnBalls = sc.nextInt();

			}
			heap2 -= drawnBalls;
		}
	}

	private void checkForWinningCondition(int turn) {
		if (heap1 == 0 && heap2 == 0) {
			if (turn % 2 == 0) {
				System.out.println("Spieler " + player1 + " hat gewonnen!");
			} else {
				System.out.println("Spieler " + player2 + " hat gewonnen!");
			}
			gameIsRunning = false;
		}
	}

	private int checkForValidHeap(Scanner sc, int heapSelected) {
		if (heapSelected < 1 || heapSelected > 2)
			while (heapSelected < 1 || heapSelected > 2) {
				System.out.println("Wählen Sie zwischen Haufen 1 und 2!");
				heapSelected = sc.nextInt();
			}
		return heapSelected;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public int getHeap1() {
		return heap1;
	}

	public void setHeap1(int heap1) {
		this.heap1 = heap1;
	}

	public int getHeap2() {
		return heap2;
	}

	public void setHeap2(int heap2) {
		this.heap2 = heap2;
	}

	public boolean isGameIsRunning() {
		return gameIsRunning;
	}

	public int getTurn() {
		return turn;
	}
}
