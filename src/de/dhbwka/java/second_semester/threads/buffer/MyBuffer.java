package de.dhbwka.java.second_semester.threads.buffer;

import java.util.ArrayDeque;
import java.util.Random;

public class MyBuffer {
	// buffer variables
	private ArrayDeque<Object> values = new ArrayDeque<>();
	private boolean flag = true;

	// the producer routine
	public synchronized void put(Object o) {
		try {
			Thread.currentThread();
			Thread.sleep(new Random().nextInt(1000)); // NOSONAR
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		if(!flag) {
			try {
				this.wait(); // NOSONAR
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		this.values.add(o);
		this.flag = false;
		// notify waiting consumer
		this.notifyAll();
		System.out.println("Put: " + o); // NOSONAR
	}

	// the consumer routine
	public synchronized Object get() {
		try {
			Thread.currentThread();
			Thread.sleep(new Random().nextInt(1000)); // NOSONAR
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		Object o;
		if (this.values.isEmpty()) {
			// consumer must wait
			// until buffer is full
			try {
				this.wait(); // NOSONAR
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		o = this.values.pop();
		System.out.println("Anzahl Elemente im Puffer: " + this.values.size()); // NOSONAR
		this.flag = true;
		this.notifyAll();
		System.out.println("Get: " + o); // NOSONAR
		return o;
	}
}
