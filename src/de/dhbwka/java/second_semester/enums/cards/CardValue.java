package de.dhbwka.java.second_semester.enums.cards;

public enum CardValue {
	SEVEN,
	EIGHT,
	NINE,
	JACK,
	QUEEN,
	KING,
	TEN,
	ACE;
	
	@Override
	public String toString() {
		switch(this.name()) {
		case "SEVEN":
			return "7";
		case "EIGHT":
			return "8";
		case "NINE":
			return "9";
		case "JACK":
			return "Jack";
		case "KING":
			return "King";
		case "TEN":
			return "10";
		case "ACE":
			return "Ace";
		case "QUEEN":
			return "Queen";
		default:
			return "Error";
			
		}
	}
}
