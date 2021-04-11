package de.dhbwka.java.exercise.classes.radio;

public class Radio {
	private boolean on;
	private int volume = 0;
	private double frequency = 85.0;

	Radio() {
		on = false;
		volume = 5;
		frequency = 85.0;
	}

	Radio(boolean on, int volume, double frequency) {
		this.on = on;
		this.volume = volume;
		this.frequency = frequency;
	}

	public void incVolume() {
		if (on == true) {
			volume++;
		}
	}

	public void decVolume() {
		if (on == true) {
			volume--;
		}
	}

	public void turnOn() {
		on = true;
	}

	public void turnOff() {
		on = false;
	}

	public void setFrequency(double frequency) {
		if (frequency < 110.0 && frequency > 85.0) {
			this.frequency = frequency;
		} else {
			this.frequency = 99.9;
		}
	}
	
	@Override
	public String toString() {
		if (on == true) {
			return "Radio an; Lautstärke=" + volume + "; Frequenz=" + frequency + "MHz";
		} else {
			return "Radio aus; Lautstärke=" + volume + "; Frequenz=" + frequency + "MHz";
		}
		
	}
}
