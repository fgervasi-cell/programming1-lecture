package de.dhbwka.java.second_semester.probeklausur.coronawarnapp;

import java.util.List;

public interface CoronaWarnClient {
	public Token getCurrentToken();
	public List<Token> getAllTokens();
	public List<Token> getAllSeenTokens();
	public void tokenReceived(Token token);
}
