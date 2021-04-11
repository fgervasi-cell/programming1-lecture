package de.dhbwka.java.exercise.classes.vehicles;

public class Car extends Vehicle {
	public Car() {
		super(4, 140.0, 0);
	}

	public Car(double speed) {
		super(4, 140.0, speed);
	}
}
