package de.dhbwka.java.second_semester.probeklausur2;

import java.awt.Color;

public enum Status {
	ACTIVE(Color.ORANGE, 0),
	CORRECT(Color.GREEN, 1),
	WRONG(Color.RED, -1),
	PENDING(Color.WHITE, 0),
	NO_ANSWER(Color.GRAY, 0);
	
	private Color c;
	private int points;
	
	Status(Color c, int points) {
		this.c = c;
		this.points = points;
	}

	public Color getColor() {
		return c;
	}


	public int getPoints() {
		return points;
	}

}
