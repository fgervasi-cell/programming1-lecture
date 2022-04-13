package de.dhbwka.java.second_semester.probeklausur2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class GameTerm implements GameClient {

	private static final String HIGHSCORES = "C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\probeklausur2\\highscore.txt";
	private String playerName;
	private Game game;
	private JLabel questionLabel;
	private JLabel secondsLabel;
	private JButton answer1;
	private JButton answer2;
	private JButton answer3;
	private JButton answer4;
	private JPanel panelNorth;
	private int points;
	private static boolean called = false;
	private int remainingSeconds;
	private static int questionIndex = -10;
	private static Thread currentThread;

	public GameTerm(String playerName, Game game) {
		this.setPlayerName(playerName);
		this.setGame(game);
		this.setPoints(0);

		JFrame frame = new JFrame(playerName);
		frame.setLayout(new BorderLayout());

		panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();

		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);

		panelNorth.setLayout(new FlowLayout());

		for (int i = 0; i < game.getNumberOfQuestions(); i++) {
			QuestionNumberLabel label = new QuestionNumberLabel(String.valueOf(i + 1), Status.PENDING);
			panelNorth.add(label);
		}

		QuestionNumberLabel first = (QuestionNumberLabel) panelNorth.getComponents()[0];
		first.changeColor(Status.ACTIVE);

		panelCenter.setLayout(new GridLayout(2, 1));
		questionLabel = new JLabel(game.getQuestions().get(0).getQuestionText());
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenter.add(questionLabel);
		secondsLabel = new JLabel("10");
		setRemainingSeconds(10);
		secondsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenter.add(secondsLabel);

		panelSouth.setLayout(new GridLayout(2, 2, 5, 5));
		Question question = game.getQuestions().get(0);
		answer1 = new JButton(question.getAnswers()[0]);
		answer1.setActionCommand("0");
		panelSouth.add(answer1);
		answer1.addActionListener(answerButtonListener);
		answer2 = new JButton(question.getAnswers()[1]);
		answer2.setActionCommand("1");
		panelSouth.add(answer2);
		answer2.addActionListener(answerButtonListener);
		answer3 = new JButton(question.getAnswers()[2]);
		answer3.setActionCommand("2");
		panelSouth.add(answer3);
		answer3.addActionListener(answerButtonListener);
		answer4 = new JButton(question.getAnswers()[3]);
		answer4.setActionCommand("3");
		answer4.addActionListener(answerButtonListener);
		panelSouth.add(answer4);

		frame.setSize(1200, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	ActionListener answerButtonListener = GameTerm.this::handleClick;

	private void handleClick(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		this.game.answerSelected(this, Integer.parseInt(clicked.getActionCommand()));
	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public int getPoints() {
		if (this.points < 0) {
			return 0;
		} else {
			return this.points;
		}
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public void setQuestion(int questionIndex, Question q) {
		this.setAnswerState(questionIndex, Status.ACTIVE);
		questionLabel.setText(q.getQuestionText());
		answer1.setText(q.getAnswers()[0]);
		answer2.setText(q.getAnswers()[1]);
		answer3.setText(q.getAnswers()[2]);
		answer4.setText(q.getAnswers()[3]);
		if(questionIndex != GameTerm.questionIndex) {
			GameTerm.questionIndex = questionIndex; // NOSONAR
			if(currentThread != null) {
				this.game.setCountdown(false);
				while(currentThread.isAlive()) {
					
				}
			}
			currentThread = new Thread(this.game.getDoCountdown()); // NOSONAR
			currentThread.start();
		}
	}

	@Override
	public void setRemainingSeconds(int seconds) {
		this.remainingSeconds = seconds;
		secondsLabel.setText(String.valueOf(seconds));
	}
	
	public int getRemainingSeconds() {
		return remainingSeconds;
	}

	@Override
	public void gameIsOver() {
		answer1.setEnabled(false);
		answer2.setEnabled(false);
		answer3.setEnabled(false);
		answer4.setEnabled(false);
		StringBuilder builder = new StringBuilder();
		for (GameClient c : this.game.getClients()) {
			if (this.game.getClients().indexOf(c) == this.game.getClients().size() - 1) {
				builder.append(c.getPlayerName() + "(" + c.getPoints() + ")");
			} else {
				builder.append(c.getPlayerName() + "(" + c.getPoints() + "), ");
			}
		}
		if(Files.exists(Paths.get(HIGHSCORES))) {
			write(builder);
		} else {
			try {
				Files.createFile(Paths.get(HIGHSCORES, (String[]) null));
				write(builder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null,
				String.format("Game finished after %s seconds, score: %s",
						(System.currentTimeMillis() - this.game.getTime()) / 1000, builder.toString()),
				"Info", JOptionPane.INFORMATION_MESSAGE);
	}

	private void write(StringBuilder builder) {
		if(!called) {
			try {
				Files.writeString(Paths.get(
						HIGHSCORES),
						builder.toString() + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
				called = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setAnswerState(int questionIndex, Status status) {
		System.out.println("questionIndex: " + questionIndex);
		for (int i = 0; i < panelNorth.getComponents().length; i++) {
			if (panelNorth.getComponents()[i] instanceof QuestionNumberLabel) {
				QuestionNumberLabel label = (QuestionNumberLabel) panelNorth.getComponents()[i];
				if (Integer.parseInt(label.getText()) == questionIndex + 1) {
					label.changeColor(status);
				}
			}
		}
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
