package com.rushteamc.yahtzee.players;

import com.rushteamc.yahtzee.dice.Dice;

public interface IYahtzoidPlayer {
	
	public void joinGame();
	
	public void leaveGame();
	
	public void startTurn();

	public void endTurn();
	
//	public YahtzoidCard drawCard();
	
	public boolean assignHand();
	
	public Dice[] rollDice(int howMany, boolean isMagic);

}
