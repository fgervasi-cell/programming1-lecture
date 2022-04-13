package de.dhbwka.java.second_semester.abstr.vehicle_new;

public class RacingCar extends Car {
	public RacingCar() {
		this.setMaxSpeed(220);
	}
	
	public RacingCar(double speed) {
		this.setMaxSpeed(220);
		this.setSpeed(speed);
	}
}
