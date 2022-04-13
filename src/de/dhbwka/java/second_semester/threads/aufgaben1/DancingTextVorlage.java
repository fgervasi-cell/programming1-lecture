package de.dhbwka.java.second_semester.threads.aufgaben1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("all")
public class DancingTextVorlage extends JComponent {

	private static final long serialVersionUID = 8113172622064692063L;
	private static final int XBASE = 30;
	private static final int XSTEP = 36;
	private static final int YBASE = 150;
	private static final Random RANDOM = new Random();

	private String text;
	private final long delay;

	private int colR = 0; // Color-Channel: red
	private int colG = 90; // Color-Channel: green
	private int colB = 180; // Color-Channel: blue
	private int yOffset = 0;

	public DancingTextVorlage(String text, long delay) {
		this.text = text;
		this.delay = delay;
	}

	/**
	 * Paint dancing text on Graphics
	 * 
	 * @param g graphics to use
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Helvetica", Font.BOLD, 48));
		for (int i = 0; i < this.text.length(); i++) {
			char c = this.text.charAt(i);

			this.colR = (this.colR + 4 + DancingTextVorlage.RANDOM.nextInt(4)) % 256;
			this.colG = (this.colG + 4 + DancingTextVorlage.RANDOM.nextInt(4)) % 256;
			this.colB = (this.colB + 4 + DancingTextVorlage.RANDOM.nextInt(4)) % 256;

			this.yOffset = DancingTextVorlage.RANDOM.nextInt(30);

			g.setColor(new Color(this.colR, this.colG, this.colB));
			g.drawString("" + c, DancingTextVorlage.XBASE + i * DancingTextVorlage.XSTEP, DancingTextVorlage.YBASE - this.yOffset);
		}
	}

	public static void main(String[] args) {
		// Create frame and add DancingText component
		JFrame f = new JFrame("Dancing Text");
		f.add(new DancingTextVorlage("Dancing Text :-)", 200));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(640, 280);
		f.setVisible(true);
	}
}
