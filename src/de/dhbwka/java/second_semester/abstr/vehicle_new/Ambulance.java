package de.dhbwka.java.second_semester.abstr.vehicle_new;

public class Ambulance extends Car {

	private boolean blueLight;

	public Ambulance(double speed, boolean blueLight) {
		setBlueLight(blueLight);
		this.setSpeed(speed);
	}

	public Ambulance() {
		setBlueLight(false);
	}

	public boolean isBlueLight() {
		return blueLight;
	}

	public void setBlueLight(boolean blueLight) {
		this.blueLight = blueLight;
	}

	@Override
	public String toString() {
		return String.format("Name: %s, Position: %s, Current Speed: %s, Wheels: %s, Maximum Speed: %s",
				this.getClass().getSimpleName(), this.getPosition(), this.getCurrentSpeed(), this.getWheels(),
				this.getMaxSpeed()) + String.format(" Signal: %s", isBlueLight());
	}
}
