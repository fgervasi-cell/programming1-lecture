package de.dhbwka.java.second_semester.probeklausur.coronawarnapp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CoronaWarnTerm implements CoronaWarnClient, Runnable {
	private JPhone phone;
	private WarnStatus status;
	private List<Token> seenTokens;
	private List<Token> ownTokens;
	private Token currentToken;
	private JLabel seenTokensLabel;
	private JLabel statusLabel;
	private JFrame frame;

	public CoronaWarnTerm(JPhone phone) {
		this.phone = phone;
		this.setStatus(WarnStatus.UNKNOWN);
		this.seenTokens = new ArrayList<>();
		this.ownTokens = CoronaWarn.loadTokens(phone);
		this.currentToken = new Token();
		CoronaWarn.saveToken(phone, this.currentToken);
		CoronaWarnAPI.sendToken(this);

		frame = new JFrame(this.phone.getOwner());
		JPanel topPanel = new JPanel();
		statusLabel = new JLabel();
		statusLabel.setOpaque(true);
		statusLabel.setBackground(this.status.getColor());
		statusLabel.setText(this.status.getText());
		statusLabel.setPreferredSize(new Dimension(0, 100));
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topPanel.add(statusLabel);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 1, 6, 3));
		JButton newToken = new JButton("New Token");
		newToken.addActionListener(e -> createNewToken());
		centerPanel.add(newToken);
		JButton checkInfectionsButton = new JButton("Check for infections"); 
		checkInfectionsButton.addActionListener(e -> checkInfections());
		centerPanel.add(checkInfectionsButton);
		JButton clearTokensButton = new JButton("Clear tokens");
		clearTokensButton.addActionListener(e -> clearTokens());
		centerPanel.add(clearTokensButton);
		JButton reportInfectionButton = new JButton("Report infection");
		reportInfectionButton.addActionListener(e -> reportInfection());
		centerPanel.add(reportInfectionButton);
		seenTokensLabel = new JLabel(String.valueOf("Seen tokens: " + this.seenTokens.size()));
		seenTokensLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seenTokensLabel.setToolTipText(this.currentToken.toString());
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(seenTokensLabel);
		frame.setLayout(new BorderLayout());
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
	}
	
	private void createNewToken() {
		Token token = new Token();
		CoronaWarn.saveToken(phone, token);
		CoronaWarnAPI.sendToken(this);
		this.ownTokens.add(token);
		this.currentToken = token;
		seenTokensLabel.setToolTipText(this.currentToken.toString());
	}
	
	private void checkInfections() {
		boolean isInfected = CoronaWarnAPI.checkInfection(this);
		System.out.println(this.status.getText());
		if(isInfected) {
			this.setStatus(WarnStatus.ALARM);
		} else {
			this.setStatus(WarnStatus.OK);
		}
		System.out.println(this.status.getText());
		this.statusLabel.setText(this.status.getText());
		this.statusLabel.setBackground(this.status.getColor());
	}
	
	private void clearTokens() {
		this.seenTokens.clear();
		this.ownTokens.clear();
		CoronaWarn.clearTokenStore(phone);
		createNewToken();
	}
	
	private void reportInfection() {
		CoronaWarnAPI.reportInfection(this);
		this.setStatus(WarnStatus.INFECTED);
		this.statusLabel.setText(this.status.getText());
		this.statusLabel.setBackground(this.status.getColor());
		for(Component c : frame.getComponents()) {
			if(c instanceof JButton) {
				JButton button = (JButton) c;
				button.setEnabled(false);
			}
		}
	}

	public Token getCurrentToken() {
		return this.currentToken;
	}

	public List<Token> getAllTokens() {
		return this.ownTokens;
	}

	public List<Token> getAllSeenTokens() {
		return this.seenTokens;
	}

	public void tokenReceived(Token token) {
		this.currentToken = token;
		this.seenTokens.add(token);
	}

	public WarnStatus getStatus() {
		return status;
	}

	public void setStatus(WarnStatus status) {
		this.status = status;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
