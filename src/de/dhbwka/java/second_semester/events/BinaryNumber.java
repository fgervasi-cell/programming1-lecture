package de.dhbwka.java.second_semester.events;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

public class BinaryNumber {
	private BinaryNumber() {

	}

	public static void open() {
		ImageIcon imgOff = new ImageIcon("C:\\Users\\fgerv\\eclipse-workspace\\University\\icons\\off.png");
		ImageIcon imgOn = new ImageIcon("C:\\Users\\fgerv\\eclipse-workspace\\University\\icons\\on.png");
		JFrame frame = new JFrame();
		JPanel toggleButtonPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel resultPanel = new JPanel();
		JLabel resultLabel = new JLabel();
		JPanel valuesPanel = new JPanel();
		for(int i = 0; i < 8; i++) {
			JLabel valueLabel = new JLabel("2^" + i + " \u279F ");
			valuesPanel.add(valueLabel);
		}
		ActionListener toggleButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component[] toggleButtons = toggleButtonPanel.getComponents();
				int result = 0;
				for(Component comp : toggleButtons) {
					JToggleButton compButton = (JToggleButton) comp;
					if(compButton.isSelected()) {
						result += Integer.parseInt(compButton.getActionCommand());
					}
				}
				resultLabel.setText(String.valueOf(result));
			}
		};
		resultPanel.add(resultLabel);
		JToggleButton buttonZero = new JToggleButton();
		buttonZero.setIcon(imgOff);
		buttonZero.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonZero);
		buttonZero.addActionListener(toggleButtonListener);
		buttonZero.setActionCommand("1");
		JToggleButton buttonOne = new JToggleButton();
		buttonOne.setIcon(imgOff);
		buttonOne.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonOne);
		buttonOne.addActionListener(toggleButtonListener);
		buttonOne.setActionCommand("2");
		JToggleButton buttonTwo = new JToggleButton();
		buttonTwo.setIcon(imgOff);
		buttonTwo.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonTwo);
		buttonTwo.addActionListener(toggleButtonListener);
		buttonTwo.setActionCommand("4");
		JToggleButton buttonThree = new JToggleButton();
		buttonThree.setIcon(imgOff);
		buttonThree.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonThree);
		buttonThree.addActionListener(toggleButtonListener);
		buttonThree.setActionCommand("8");
		JToggleButton buttonFour = new JToggleButton();
		buttonFour.setIcon(imgOff);
		buttonFour.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonFour);
		buttonFour.addActionListener(toggleButtonListener);
		buttonFour.setActionCommand("16");
		JToggleButton buttonFive = new JToggleButton();
		buttonFive.setIcon(imgOff);
		buttonFive.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonFive);
		buttonFive.addActionListener(toggleButtonListener);
		buttonFive.setActionCommand("32");
		JToggleButton buttonSix = new JToggleButton();
		buttonSix.setIcon(imgOff);
		buttonSix.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonSix);
		buttonSix.addActionListener(toggleButtonListener);
		buttonSix.setActionCommand("64");
		JToggleButton buttonSeven = new JToggleButton();
		buttonSeven.setIcon(imgOff);
		buttonSeven.setSelectedIcon(imgOn);
		toggleButtonPanel.add(buttonSeven);
		buttonSeven.addActionListener(toggleButtonListener);
		buttonSeven.setActionCommand("128");
		mainPanel.add(toggleButtonPanel, BorderLayout.NORTH);
		mainPanel.add(resultPanel, BorderLayout.SOUTH);
		mainPanel.add(valuesPanel, BorderLayout.CENTER);
		frame.add(mainPanel);
		frame.setTitle("Binary Number");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setSize(800, 200);
		frame.setVisible(true);
	}
}
