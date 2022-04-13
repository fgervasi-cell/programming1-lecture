package de.dhbwka.java.second_semester.enums.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardGame {
	private static final int NUMBER_OF_CARDS = 32;
	private List<PlayingCard> cardStack;

	public CardGame() {
		this.cardStack = new ArrayList<>();
		Random rnd = new Random();
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			this.cardStack.add(new PlayingCard(CardValue.values()[rnd.nextInt(CardValue.values().length)], Suit.values()[rnd.nextInt(Suit.values().length)]));
		}
	}

	public void shuffle() {
		Collections.shuffle(this.cardStack);
	}

	public void sort() {
		this.cardStack.sort(null);
	}

	public PlayingCard get() {
		return this.cardStack.remove(this.cardStack.size() - 1);
	}

	public List<PlayingCard> all() {
		return this.cardStack;
	}
}
