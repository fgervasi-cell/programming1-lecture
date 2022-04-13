package de.dhbwka.java.second_semester.ui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class ComponentFrame extends JFrame {
	
	private static final long serialVersionUID = 2561395278300976690L;

	public void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.setTitle("Several basic Swing components");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(new JLabel("JLabel"));
		panel.add(new JTextField(10));
		panel.add(new JPasswordField(10));
		JButton button = new JButton("JButton");
		button.setToolTipText("This is a tooltip");
		panel.add(button);
		panel.add(new JToggleButton("JToggleButton"));
		JCheckBox check = new JCheckBox();
		check.setText("JCheckBox");
		panel.add(check);
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("Item 1");
		comboBox.addItem("Item 2");
		comboBox.addItem("Item 3");
		panel.add(comboBox);
		ButtonGroup group = new ButtonGroup();
		JRadioButton button1 = new JRadioButton();
		button1.setText("Radio-Button-1");
		JRadioButton button2 = new JRadioButton();
		button2.setText("Radio-Button-2");
		JRadioButton button3 = new JRadioButton();
		button3.setText("Radio-Button-3");
		group.add(button1);
		group.add(button2);
		group.add(button3);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
