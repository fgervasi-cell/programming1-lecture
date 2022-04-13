package de.dhbwka.java.second_semester.ui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CurrencyCalculator {
	
	private CurrencyCalculator() {
		
	}
	
	public static void start() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(5, 5));
		JButton eToD = new JButton("EUR \u279F USD");
		JButton dToE = new JButton("USD \u279F EUR");
		JButton cancel = new JButton("Cancel");
		eToD.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		dToE.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		cancel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		JTextField textField = new JTextField();
		textField.setToolTipText("Please enter amount to convert!");
		panel.add(textField, BorderLayout.NORTH);
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		southPanel.add(dToE);
		southPanel.add(eToD);
		southPanel.add(cancel);
		panel.add(southPanel);
		frame.add(panel);
		frame.setTitle("Currency Converter");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
