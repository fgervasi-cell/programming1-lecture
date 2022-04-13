package de.dhbwka.java.second_semester.enums.cards;

public class TestGame {
	public static void main(String[] args) {
		CardGame game = new CardGame();
		PlayingCard comparison = new PlayingCard(CardValue.SEVEN, Suit.HEART);
		game.sort();
		System.out.println("Karten sortiert:");
		for(int i = 0; i < game.all().size(); i++) {
			System.out.println(game.all().get(i));
		}
		System.out.println();
		game.shuffle();
		System.out.println("Karten gemischt:");
		for(int i = 0; i < game.all().size(); i++) {
			System.out.println(game.all().get(i));
		}
		System.out.println();
		System.out.println("Vergleich mit Herz 7:");
		for (int i = 0; i < 10; i++) {
			PlayingCard card = game.get();
			System.out.println(card);
			switch(card.compareTo(comparison)) {
			case -1:
				System.out.println(String.format("%s schlaegt", comparison));
				break;
			case 1:
				System.out.println(String.format("%s wird geschlagen", comparison));
				break;
			default:
				System.out.println("Error...");
			}
		}
	}
}
