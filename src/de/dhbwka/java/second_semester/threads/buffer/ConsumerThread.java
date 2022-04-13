package de.dhbwka.java.second_semester.threads.buffer;

public class ConsumerThread extends Thread {
	private MyBuffer buffer;

	public ConsumerThread(MyBuffer b) {
		this.buffer = b;
	}

	@Override
	public void run() {
		while(true) {
			this.buffer.get();
		}
	}
}
