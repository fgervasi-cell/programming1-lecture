package de.dhbwka.java.exercise.classes.vehicles;

public class Bicycle extends Vehicle {
	public Bicycle() {
		super(2, 30.0, 0);
	}

	public Bicycle(double speed) {
		super(2, 30.0, speed);
	}
}
