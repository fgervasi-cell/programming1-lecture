package de.dhbwka.java.second_semester.threads.buffer;

public class BufferTest {

	public static void main(String[] args) {
		MyBuffer buffer = new MyBuffer();

		ProducerThread producerThread = new ProducerThread(buffer);
		producerThread.start();

		ConsumerThread consumerThread = new ConsumerThread(buffer);
		consumerThread.start();
	}

}
