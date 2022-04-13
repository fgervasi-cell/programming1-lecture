package de.dhbwka.java.second_semester.probeklausur2;

import java.awt.Dimension;

import javax.swing.JLabel;

public class QuestionNumberLabel extends JLabel {
	private static final long serialVersionUID = -7944098333403796401L;

	public QuestionNumberLabel(String text, Status status) {
		super(text);
		this.setPreferredSize(new Dimension(100, 50));
		this.setOpaque(true);
		this.setHorizontalAlignment(CENTER);
		this.setBackground(status.getColor());
	}
	
	public void changeColor(Status status) {
		this.setBackground(status.getColor());
	}
}
