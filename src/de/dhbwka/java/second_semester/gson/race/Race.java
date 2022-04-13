package de.dhbwka.java.second_semester.gson.race;

import java.util.ArrayList;
import java.util.List;

public class Race {
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public Race(List<Vehicle> vehicles) {
		this.setVehicles(vehicles);
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
