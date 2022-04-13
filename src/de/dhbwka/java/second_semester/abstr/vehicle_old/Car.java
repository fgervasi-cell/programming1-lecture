package de.dhbwka.java.second_semester.abstr.vehicle_old;

public class Car extends Vehicle {
	public Car() {
		this.setWheels(4);
		this.setMaxSpeed(140);
	}
	
	public Car(double speed) {
		this.setWheels(4);
		this.setMaxSpeed(140);
		this.setSpeed(speed);
	}
}
