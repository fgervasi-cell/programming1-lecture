package de.dhbwka.java.second_semester.threads.buffer;

import java.util.Random;

public class ProducerThread extends Thread {
	private MyBuffer buffer;
	private Random rnd;

	public ProducerThread(MyBuffer b) {
		this.buffer = b;
		this.rnd = new Random();
	}

	@Override
	public void run() {
		while(true) {
			this.buffer.put(rnd.nextLong());
		}
	}
}
