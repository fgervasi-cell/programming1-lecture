package de.dhbwka.java.second_semester.threads.aufgaben1;

public class LightPhase {
	private String name;
	private boolean red;
	private boolean yellow;
	private boolean green;
	private long duration;
	
	public LightPhase(String name, boolean red, boolean yellow, boolean green, long duration) {
		this.name = name;
		this.red = red;
		this.yellow = yellow;
		this.green = green;
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Red: %s, Yellow: %s, Green: %s", this.name, this.red, this.yellow, this.green);
	}
	
	public String getName() {
		return name;
	}

	public boolean isRed() {
		return red;
	}

	public boolean isYellow() {
		return yellow;
	}

	public boolean isGreen() {
		return green;
	}

	public long getDuration() {
		return duration;
	}
	
}
