package de.dhbwka.java.second_semester.abstr.vehicle_old;

public class Bicycle extends Vehicle {
	public Bicycle() {
		this.setWheels(2);
		this.setMaxSpeed(30);
	}
	
	public Bicycle(double speed) {
		this.setWheels(2);
		this.setMaxSpeed(30);
		this.setSpeed(speed);
	}
}
