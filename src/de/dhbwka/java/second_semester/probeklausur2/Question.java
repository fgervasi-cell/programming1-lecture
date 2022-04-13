package de.dhbwka.java.second_semester.probeklausur2;

import java.util.Arrays;

public class Question {
	private String questionText;
	private String[] answers;
	private int correctIndex;
	
	public Question(String questionText, String[] answers, int correctIndex) {
		setQuestionText(questionText);
		setAnswers(answers);
		setCorrectIndex(correctIndex);
	}
	
	@Override
	public String toString() {
		return String.format("questionText: %s, answers: %s, correctIndex: %s", this.questionText, Arrays.toString(this.answers), this.correctIndex);
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public int getCorrectIndex() {
		return correctIndex;
	}

	public void setCorrectIndex(int correctIndex) {
		this.correctIndex = correctIndex;
	}
}
