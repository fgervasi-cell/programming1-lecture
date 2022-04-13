package de.dhbwka.java.second_semester.probeklausur2;

public interface GameClient {
	/**
	 * Returns the name of a player.
	 * 
	 * @return the player name
	 */
	public String getPlayerName();

	/**
	 * Returns the number of points of this player.
	 * 
	 * @return the number of points <br>
	 *         0 if the number of points is negative
	 */
	public int getPoints();

	/**
	 * Sets the current question out of the list of questions for the game for the
	 * player.
	 * 
	 * @param questionIndex - the index of the question in the list of questions for
	 *                      the game
	 * @param q             - the question object
	 */
	public void setQuestion(int questionIndex, Question q);

	/**
	 * Tells the player how many seconds he has left to answer the question.
	 * 
	 * @param seconds - the time in seconds
	 */
	public void setRemainingSeconds(int seconds);

	/**
	 * Tells the player that the game is over.
	 */
	public void gameIsOver();

	/**
	 * Sets the status of the player for the current question. For an example this
	 * method is called when the player logs in an answer.
	 * 
	 * @param questionIndex - the index of the question in the list of questions for
	 *                      the game
	 * @param status        - the status for the player
	 */
	public void setAnswerState(int questionIndex, Status status);
}
