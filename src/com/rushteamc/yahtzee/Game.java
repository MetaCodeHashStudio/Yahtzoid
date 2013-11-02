package com.rushteamc.yahtzee;

import com.rushteamc.yahtzee.players.Player;

public class Game implements IYahtzoidGame
{
	Player[] player;
	int numPlayers;
	
	
	public Game(String[] playerNames) {
			this.numPlayers = playerNames.length;
			
	}
	
	public void nextTurn() {
		
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public String getPlayerNames(int index) {
		
	}
	
}
