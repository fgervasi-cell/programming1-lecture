package de.dhbwka.java.second_semester.threads.aufgaben1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TrafficLight extends JComponent implements Runnable {

	private static final long serialVersionUID = 405633757260635657L;
	private static final long DELAY = 2000;
	private static final List<LightPhase> lightPhases = new ArrayList<>();
	private boolean isRed = true;
	private boolean isYellow = false;
	private boolean isGreen = false;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// traffic light box
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 80, 195);

		// 3 x empty light
		g.setColor(Color.WHITE);
		g.fillOval(23, 23, 54, 54);
		g.fillOval(23, 83, 54, 54);
		g.fillOval(23, 143, 54, 54);

		/*
		 * ====================================================
		 * ==================================================== SET THE CORRECT VALUES
		 * FOR THE FOLLOWING 3 VARIABLES
		 * ====================================================
		 * ====================================================
		 */

		// draw colored lights, if active
		if (isRed) {
			g.setColor(Color.RED);
			g.fillOval(25, 25, 50, 50);
		}

		if (isYellow) {
			g.setColor(Color.YELLOW);
			g.fillOval(25, 85, 50, 50);
		}
		if (isGreen) {
			g.setColor(Color.GREEN);
			g.fillOval(25, 145, 50, 50);
		}
	}

	public static void main(String[] args) {
		// Create frame and add TrafficLight component
		lightPhases.add(new LightPhase("redPhase", true, false, false, DELAY));
		lightPhases.add(new LightPhase("redYellowPhase", true, true, false, DELAY));
		lightPhases.add(new LightPhase("greenPhase", false, false, true, 2*DELAY));
		lightPhases.add(new LightPhase("yellowPhase", false, true, false, DELAY));
		JFrame f = new JFrame("Traffic Light");
		TrafficLight trafficLight = new TrafficLight();
		f.add(trafficLight);
		Thread thread = new Thread(trafficLight);
		thread.start();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setSize(300, 360);
		f.setVisible(true);
	}

	@Override
	public void run() {
		while (true) { // NOSONAR
			try {
				for (int i = 0; i < lightPhases.size(); i++) {
					isRed = lightPhases.get(i).isRed();
					isYellow = lightPhases.get(i).isYellow();
					isGreen = lightPhases.get(i).isGreen();
					System.out.println(lightPhases.get(i).toString());
					this.repaint();
					Thread.sleep(lightPhases.get(i).getDuration());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
				break;
			}
		}
	}

}
