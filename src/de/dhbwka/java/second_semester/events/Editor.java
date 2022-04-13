package de.dhbwka.java.second_semester.events;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class Editor {

	private JMenuItem open;
	private JMenuItem newOption;
	private JMenuItem saveMenuItem;
	private JMenuItem exitItem;
	private JFrame frame;
	private JTextPane textPane;
	private File selected;

	public Editor() {
		frame = new JFrame();
		textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textPane.setText("Open a file to view its text here...");
		textPane.setContentType("text/plain");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		newOption = new JMenuItem("Neu");
		fileMenu.add(newOption);
		open = new JMenuItem("Öffnen");
		fileMenu.add(open);
		fileMenu.add(new JSeparator());
		fileMenu.add(new JMenuItem("Schließen"));
		fileMenu.add(new JSeparator());
		saveMenuItem = new JMenuItem("Speichern");
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
		saveMenuItem.setEnabled(false);
		fileMenu.add(saveMenuItem);
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
		send.add(new JMenuItem("E-Mail-Empfänger"));
		send.add(new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)"));
		send.add(new JMenuItem("E-Mail-Empfänger (als Anlage)"));
		send.add(new JSeparator());
		send.add(new JMenuItem("Verteilerempfänger..."));
		send.add(new JMenuItem("Onlinebesprechungsteilnehmer"));
		send.add(new JMenuItem("Exchange Ordner..."));
		send.add(new JMenuItem("Fax-Empfänger..."));
		send.add(new JSeparator());
		send.add(new JMenuItem("Microsoft PowerPoint"));
		fileMenu.add(send);
		fileMenu.add(new JMenuItem("Eigenschaften"));
		fileMenu.add(new JSeparator());
		exitItem = new JMenuItem("Beenden");
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		JMenu edit = new JMenu("Bearbeiten");
		edit.add(new JMenuItem("Rückgängig"));
		edit.add(new JMenuItem("Wiederholen"));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("Ausschneiden"));
		edit.add(new JMenuItem("Kopieren"));
		edit.add(new JMenuItem("Office-Zwischenablage"));
		edit.add(new JMenuItem("Einfügen"));
		edit.add(new JMenuItem("Inhalte einfügen"));
		edit.add(new JMenuItem("Als Hyperlink einfügen"));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("Löschen"));
		edit.add(new JMenuItem("Alles markieren"));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("Suchen..."));
		edit.add(new JMenuItem("Ersetzen..."));
		edit.add(new JMenuItem("Gehe zu..."));
		edit.add(new JSeparator());
		edit.add(new JMenuItem("Verknüpfungen..."));
		edit.add(new JMenuItem("Objekt"));
		menuBar.add(edit);
		mainPanel.add(menuBar, BorderLayout.NORTH);
		addActionListeners();
		frame.add(mainPanel);
		frame.setTitle("Editor");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

	private void addActionListeners() { 
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Opening JFileChooser...");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {

					@Override
					public String getDescription() {
						return "Text files";
					}

					@Override
					public boolean accept(File f) {
						return f.getAbsolutePath().endsWith(".txt") || f.isDirectory();
					}
				});
				fileChooser.showOpenDialog(frame);
				selected = fileChooser.getSelectedFile();
				StringBuilder builder = new StringBuilder();
				if(selected != null) {
					try(BufferedReader reader = new BufferedReader(new FileReader(selected))) {
						System.out.println("Reading file...");
						while(reader.ready()) {
							builder.append(reader.readLine());
						}
					} catch(IOException exception) {
						System.out.println("IOException occured!!!");
					}
					textPane.setText(builder.toString());
					saveMenuItem.setEnabled(true);
				}
			}
		});
		
		newOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textPane.setText("Open a file to view its text here...");
				saveMenuItem.setEnabled(false);
			}
		});
		
		saveMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try(BufferedWriter writer = new BufferedWriter(new FileWriter(selected))) {
					System.out.println("Writing to file...");
					writer.write(textPane.getText());
				} catch(IOException exception) {
					System.out.println("IOException occured!!! That is no good...");
				}
			}
		});
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void start() {
		frame.setVisible(true);
	}

}
