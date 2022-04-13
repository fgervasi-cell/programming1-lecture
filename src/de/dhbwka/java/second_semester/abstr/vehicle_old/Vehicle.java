package de.dhbwka.java.second_semester.abstr.vehicle_old;

public class Vehicle {

	private int wheels;
	private int maxSpeed;
	private double currentSpeed;
	private double position;
	
	public Vehicle() {
		setWheels(0);
		setMaxSpeed(0);
		setSpeed(0);
		setPosition(0);
	}
	
	public void drive(double minutes) {
		if(this.getCurrentSpeed() != 0) {
			this.setPosition(this.getPosition() + ((minutes/60)*getCurrentSpeed()));
		}
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Position: %s, Current Speed: %s, Wheels: %s, Maximum Speed: %s", this.getClass().getSimpleName(), this.getPosition(), this.getCurrentSpeed(), this.getWheels(), this.getMaxSpeed());
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setSpeed(double speed) {
		if(speed <= getMaxSpeed()) {
			this.currentSpeed = speed;
		} else {
			this.currentSpeed = getMaxSpeed();
		}
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}
	
}
