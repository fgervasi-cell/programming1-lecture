package de.dhbwka.java.second_semester.ui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
//		ComponentFrame componentFrame = new ComponentFrame();
//		componentFrame.init();
		
//		new TextFrame(args[0], args[1], args[2]);
		
//		TextFileViewer viewer = new TextFileViewer();
//		viewer.init();
		
//		CurrencyCalculator.start();
		
		Editor editor = new Editor();
		editor.start();
	}

}
