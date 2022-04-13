package de.dhbwka.java.second_semester.events;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JTextField textField = new JTextField();
		eToD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(String.valueOf(Double.parseDouble(textField.getText())*1.09));
				} catch(NumberFormatException exception) {
					textField.setText("Not a valid input!");
				}
				
			}
		});
		JButton dToE = new JButton("USD \u279F EUR");
		dToE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(String.valueOf(Double.parseDouble(textField.getText())/1.09));
				} catch(NumberFormatException exception) {
					textField.setText("Not a valid input!");
				}
				
			}
		});
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		eToD.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		dToE.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		cancel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
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
