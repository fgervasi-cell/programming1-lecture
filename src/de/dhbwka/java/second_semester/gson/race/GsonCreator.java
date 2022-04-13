package de.dhbwka.java.second_semester.gson.race;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonCreator {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Vehicle(4, 200.0, 35.4, 143.7));
		vehicles.add(new Car(130.0));
		vehicles.add(new Ambulance(111, 150, true));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(new Race(vehicles)));
	}
}
