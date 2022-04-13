package de.dhbwka.java.second_semester.gson.race;

public class Ambulance extends Vehicle {
	
	private boolean blueLight;

	public Ambulance(double position, double currentSpeed, boolean blueLight) {
		super(4, 200, position, currentSpeed);
		setBlueLight(blueLight);
	}

	public boolean isBlueLight() {
		return blueLight;
	}

	public void setBlueLight(boolean blueLight) {
		this.blueLight = blueLight;
	}

}
