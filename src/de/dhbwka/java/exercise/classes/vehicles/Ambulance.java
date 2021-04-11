package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car {
	private boolean blueLight;

	public Ambulance() {
		super();
		setBlueLight(false);	
	}
	
	public Ambulance(double speed, boolean blueLight) {
		super.setSpeed(speed);
		setBlueLight(blueLight);
	}

	public boolean isBlueLight() {
		return blueLight;
	}

	public void setBlueLight(boolean blueLight) {
		this.blueLight = blueLight;
	}
	
	@Override
	public String toString() {
		if (this.blueLight) {
			return super.toString() + " Signal on."; 
		} else {
			return super.toString() + " Signal off."; 
		}
	}
}
