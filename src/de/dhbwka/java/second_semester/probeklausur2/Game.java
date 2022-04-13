package de.dhbwka.java.second_semester.probeklausur2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Game {
	private List<Question> questionsSelected;
	private List<GameClient> clients;
	private int numberOfQuestions;
	private boolean gameStarted;
	private Question currentQuestion;
	private long timeStart;
	private Runnable doCountdown = this::count;
	private boolean countdown;

	public Game(List<Question> questionsPool, int numberOfQuestions) throws GameException {
		if (questionsPool.size() < numberOfQuestions) {
			throw new GameException("Too few questions available");
		}
		setQuestions(new ArrayList<>());
		setClients(new ArrayList<>());
		setGameStarted(false);
		setNumberOfQuestions(numberOfQuestions);
		Random rnd = new Random();
		Set<Question> questions = new HashSet<>();
		while(questions.size() < numberOfQuestions) {
			Collections.shuffle(questionsPool);
			questions.add(questionsPool.get(rnd.nextInt(questionsPool.size())));
		}
		questionsSelected = new ArrayList<>(questions);
	}
	
	private void count() {
		setCountdown(true);
		this.clients.forEach(c -> c.setRemainingSeconds(10));
		while(isCountdown()) {
			try {
				this.clients.forEach(c -> {
					GameTerm term = (GameTerm) c;
					term.setRemainingSeconds(term.getRemainingSeconds() - 1);
				});
				Thread.sleep(1000);
				GameTerm term = (GameTerm) this.clients.get(0);
				if(term.getRemainingSeconds() == 0) {
					setCountdown(false);
					this.clients.forEach(c -> {
						c.setAnswerState(this.questionsSelected.indexOf(this.currentQuestion), Status.NO_ANSWER);
					});
					if(this.questionsSelected.indexOf(this.currentQuestion) + 1 == this.questionsSelected.size()) {
						this.clients.forEach(GameClient::gameIsOver);
						return;
					}
					setCurrentQuestion(this.questionsSelected.get(this.questionsSelected.indexOf(this.currentQuestion) + 1));
					this.clients.forEach(c -> {
						c.setQuestion(this.questionsSelected.indexOf(this.currentQuestion), this.currentQuestion);
					});
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}

	public void registerClient(GameClient client) {
		if (!isGameStarted()) {
			clients.add(client);
		}
	}

	public void startGame() {
		setTime(System.currentTimeMillis());
		setGameStarted(true);
		for (GameClient c : clients) {
			setCurrentQuestion(questionsSelected.get(0));
			c.setQuestion(0, questionsSelected.get(0));
		}
	}

	public void answerSelected(GameClient client, int index) {
		System.out.println("index: " + index);
		System.out.println(this.currentQuestion);
		if(this.currentQuestion.getCorrectIndex() == index) {
			client.setAnswerState(this.questionsSelected.indexOf(this.currentQuestion), Status.CORRECT);
			GameTerm term = (GameTerm) client;
			term.setPoints(term.getPoints() + 1);
		} else {
			client.setAnswerState(this.questionsSelected.indexOf(this.currentQuestion), Status.WRONG);
			GameTerm term = (GameTerm) client;
			term.setPoints(term.getPoints() - 1);
		}
		if(this.questionsSelected.indexOf(this.currentQuestion) + 1 == this.questionsSelected.size()) {
			this.clients.forEach(GameClient::gameIsOver);
			return;
		}
		for(GameClient c : this.clients) {
			if(!c.equals(client)) {
				c.setAnswerState(this.questionsSelected.indexOf(this.currentQuestion), Status.NO_ANSWER);
			}
		}
		setCurrentQuestion(this.questionsSelected.get(this.questionsSelected.indexOf(this.currentQuestion) + 1));
		this.clients.forEach(c -> c.setQuestion(this.questionsSelected.indexOf(this.currentQuestion), this.currentQuestion));
	}

	/**
	 * Returns the randomly selected questions for the current game.
	 * @return the selected questions for the game
	 */
	public List<Question> getQuestions() {
		return this.questionsSelected;
	}

	/**
	 * Sets the questions for the game.
	 * @param the list of questions to be selected
	 */
	public void setQuestions(List<Question> questions) {
		this.questionsSelected = questions;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public List<GameClient> getClients() {
		return clients;
	}

	public void setClients(List<GameClient> clients) {
		this.clients = clients;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	public Question getCurrentQuestion() {
		return this.currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public long getTime() {
		return timeStart;
	}

	public void setTime(long time) {
		this.timeStart = time;
	}

	public Runnable getDoCountdown() {
		return doCountdown;
	}

	public void setDoCountdown(Runnable doCountdown) {
		this.doCountdown = doCountdown;
	}

	public boolean isCountdown() {
		return countdown;
	}

	public void setCountdown(boolean countdown) {
		this.countdown = countdown;
	}

}
