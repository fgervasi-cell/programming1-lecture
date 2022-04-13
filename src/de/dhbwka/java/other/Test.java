package de.dhbwka.java.other;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
		JLabel helloWorldLabel = new JLabel("Hello World!", SwingConstants.CENTER);
		helloWorldLabel.setFont(new Font("Helvetica", Font.BOLD, 50));
		frame.add(helloWorldLabel, BorderLayout.CENTER);
		changeColors(helloWorldLabel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	private static void changeColors(JLabel label) {
		Random rnd = new Random();
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				while (true) { // NOSONAR
					int r = rnd.nextInt(255);
					int g = rnd.nextInt(255);
					int b = rnd.nextInt(255);
					label.setForeground(new Color(r, g, b));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(r).start();
		
	}

}
