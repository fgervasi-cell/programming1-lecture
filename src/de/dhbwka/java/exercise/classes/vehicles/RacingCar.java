package de.dhbwka.java.exercise.classes.vehicles;

public class RacingCar extends Car {
	public RacingCar() {
		super();
		super.setMaxSpeed(220.0);
	}
	
	public RacingCar(double speed) {
		super.setMaxSpeed(220.0);
		super.setSpeed(speed);
	}
}
