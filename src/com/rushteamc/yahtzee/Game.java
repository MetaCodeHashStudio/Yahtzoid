package com.rushteamc.yahtzee;


public class Game implements IYahtzoidGame
{
	
	public Game(int numPlayers, String[] playerNames) throws IllegalArgumentException {
		if(numPlayers != playerNames.length) {
			throw new IllegalArgumentException();
		}
		
	}

}
