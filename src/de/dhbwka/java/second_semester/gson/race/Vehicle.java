package de.dhbwka.java.second_semester.gson.race;

public class Vehicle {
	private int numberOfWheels;
	private double maxSpeed;
	private double position;
	private double currentSpeed;
	
	public Vehicle(int numberOfWheels, double maxSpeed, double position, double currentSpeed) {
		this.setNumberOfWheels(numberOfWheels);
		this.setMaxSpeed(maxSpeed);
		this.setPosition(position);
		this.setCurrentSpeed(currentSpeed);
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
}
