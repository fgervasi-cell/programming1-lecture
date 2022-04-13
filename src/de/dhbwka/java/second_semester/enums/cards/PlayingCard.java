package de.dhbwka.java.second_semester.enums.cards;

public class PlayingCard implements Comparable<PlayingCard> {
	private CardValue value;
	private Suit suit;

	public PlayingCard(CardValue value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return String.format("%s %s", this.suit.name().charAt(0) + this.suit.name().substring(1).toLowerCase(), this.value);
	}

	@Override
	public int compareTo(PlayingCard c) {
		if (this.suit.ordinal() < c.suit.ordinal()) {
			return -1;
		} else if(this.suit.ordinal() == c.suit.ordinal()) {
			if(this.value.ordinal() < c.value.ordinal()) {
				return -1;
			}
			return 1;
		} else {
			return 1;
		}
	}
}
