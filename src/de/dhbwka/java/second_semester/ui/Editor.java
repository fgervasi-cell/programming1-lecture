package de.dhbwka.java.second_semester.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

public class Editor extends JFrame {

	private static final long serialVersionUID = -8214257446898794408L;

	public Editor() {
		
	}
	
	public void start() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		fileMenu.add(new JMenuItem("Neu"));
		fileMenu.add(new JMenuItem("�ffnen"));
		fileMenu.add(new JSeparator());
		fileMenu.add(new JMenuItem("Schlie�en"));
		fileMenu.add(new JSeparator());
		fileMenu.add(new JMenuItem("Speichern"));
		fileMenu.add(new JMenuItem("Speichern unter..."));
		fileMenu.add(new JMenuItem("Als Webseite speichern"));
		fileMenu.add(new JMenuItem("Suchen"));
		fileMenu.add(new JSeparator());
		fileMenu.add(new JMenuItem("Versionen"));
		fileMenu.add(new JSeparator());
		fileMenu.add(new JMenuItem("Webseitenvorschau"));
		fileMenu.add(new JSeparator());
		fileMenu.add(new JMenuItem("Seite einrichten..."));
		fileMenu.add(new JMenuItem("Seitenansicht"));
		fileMenu.add(new JMenuItem("Drucken"));
		fileMenu.add(new JSeparator());
		JMenu send = new JMenu("Senden an");
		send.add(new JMenuItem("E-Mail-Empf�nger"));
		send.add(new JMenuItem("E-Mail-Empf�nger (zur �berarbeitung)"));
		send.add(new JMenuItem("E-Mail-Empf�nger (als Anlage)"));
		send.add(new JSeparator());
		send.add(new JMenuItem("Verteilerempf�nger..."));
		send.add(new JMenuItem("Onlinebesprechungsteilnehmer"));
		send.add(new JMenuItem("Exchange Ordner..."));
		send.add(new JMenuItem("Fax-Empf�nger..."));
		send.add(new JSeparator());
		send.add(new JMenuItem("Microsoft PowerPoint"));
		fileMenu.add(send);
		fileMenu.add(new JMenuItem("Eigenschaften"));
		fileMenu.add(new JSeparator());
		fileMenu.add(new JMenuItem("Beenden"));
		menuBar.add(fileMenu);
		JMenu edit = new JMenu("Bearbeiten");
		edit.add(new JMenuItem("R�ckg�ngig"));
		edit.add(new JMenuItem("Wiederholen"));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("Ausschneiden"));
		edit.add(new JMenuItem("Kopieren"));
		edit.add(new JMenuItem("Office-Zwischenablage"));
		edit.add(new JMenuItem("Einf�gen"));
		edit.add(new JMenuItem("Inhalte einf�gen"));
		edit.add(new JMenuItem("Als Hyperlink einf�gen"));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("L�schen"));
		edit.add(new JMenuItem("Alles markieren"));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("Suchen..."));
		edit.add(new JMenuItem("Ersetzen..."));
		edit.add(new JMenuItem("Gehe zu..."));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("Verkn�pfungen..."));
		edit.add(new JMenuItem("Objekt"));
		menuBar.add(edit);
		mainPanel.add(menuBar, BorderLayout.NORTH);
		this.add(mainPanel);
		this.setTitle("Editor");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
