package de.dhbwka.java.exercise.classes.vehicles;

public class Vehicle {
	private int numberOfWheels;
	private double maxSpeed;
	private double position;
	private double currentSpeed;

	public Vehicle() {
		setNumberOfWheels(0);
		setMaxSpeed(0);
		setSpeed(0);
		setPosition(0);
	}

	public Vehicle(int numberOfWheels, double maxSpeed, double currentSpeed) {
		setNumberOfWheels(numberOfWheels);
		setMaxSpeed(maxSpeed);
		setPosition(0);
		setSpeed(currentSpeed);
	}

	public void setSpeed(double speed) {
		if (speed <= this.maxSpeed) {
			this.currentSpeed = speed;
		} else {
			this.currentSpeed = this.maxSpeed;
		}
	}

	public void drive(double minutes) {
		if (this.currentSpeed > 0) {
			for (int i = 0; i < minutes; i++) {
				position += this.currentSpeed * 0.0166667;
			}
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " at position " + this.position + " km with " + this.numberOfWheels + " wheels at speed "
				+ this.currentSpeed + " km/h of max. " + this.maxSpeed + " km/h.";
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

	public void setPosition(int position) {
		this.position = position;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

}
