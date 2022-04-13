package de.dhbwka.java.second_semester.abstr.vehicle_new;

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

	@Override
	public void info() {
		System.out.println(this.toString());
	}
}
