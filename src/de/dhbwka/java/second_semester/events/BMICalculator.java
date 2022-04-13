package de.dhbwka.java.second_semester.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BMICalculator {
	private BMICalculator() {

	}

	public static void open() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JRadioButton male = new JRadioButton();
		JRadioButton female = new JRadioButton();
		JTextField weightInput = new JTextField();
		JTextField heightInput = new JTextField();
		JTextField bmi = new JTextField();
		JTextField result = new JTextField();
		JButton calc = new JButton("Calculate");
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (male.isSelected() || female.isSelected()) {
					try {
						double bmiResult = Double.parseDouble(weightInput.getText())
								/ Math.pow(2, Double.parseDouble(heightInput.getText()));
						bmi.setText(String.valueOf(bmiResult));
						checkClassification(male.isSelected(), bmiResult);
					} catch (NumberFormatException exception) {
						result.setText("Invalid input!");
					}
				} else {
					result.setText("You need to select a gender!");
				}
			}

			private void checkClassification(boolean male, double bmiResult) {
				if (male) {
					if (bmiResult < 20) {
						result.setText("Short weight");
					} else if (bmiResult > 20 && bmiResult < 25) {
						result.setText("Normal weight");
					} else if (bmiResult > 25 && bmiResult < 30) {
						result.setText("Overweight");
					} else if (bmiResult > 30 && bmiResult < 40) {
						result.setText("Adiposity");
					} else {
						result.setText("Massive Adiposity");
					}
				} else {
					if (bmiResult < 19) {
						result.setText("Short weight");
					} else if (bmiResult > 19 && bmiResult < 24) {
						result.setText("Normal weight");
					} else if (bmiResult > 24 && bmiResult < 30) {
						result.setText("Overweight");
					} else if (bmiResult > 30 && bmiResult < 40) {
						result.setText("Adiposity");
					} else {
						result.setText("Massive Adiposity");
					}
				}
			}
		});
		JLabel bmiLabel = new JLabel("BMI:");
		JLabel weightInputLabel = new JLabel("Weight [kg]:");
		JLabel heightInputLabel = new JLabel("Body height [m]:");
		group.add(male);
		group.add(female);
		panel.add(weightInputLabel);
		weightInput.setColumns(15);
		panel.add(weightInput);
		panel.add(heightInputLabel);
		heightInput.setColumns(15);
		panel.add(heightInput);
		male.setText("male");
		panel.add(male);
		female.setText("female");
		panel.add(female);
		panel.add(calc);
		panel.add(bmiLabel);
		bmi.setColumns(15);
		bmi.setEditable(false);
		panel.add(bmi);
		result.setColumns(15);
		result.setEditable(false);
		panel.add(result);
		frame.add(panel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("BMI Calculator");
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
