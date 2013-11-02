package com.rushteamc.yahtzee;

public interface IYahtzoidGame {
	
	public void nextTurn();
	
	public int getNumPlayers();
	
	public String getPlayerNames(int index);
	
	public String[] getPlayerNames();

	
}
