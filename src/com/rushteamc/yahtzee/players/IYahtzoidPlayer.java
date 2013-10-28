package com.rushteamc.yahtzee.players;

import com.rushteamc.yahtzee.dice.Dice;

public interface IYahtzoidPlayer {
	
	public boolean setName();
	
	public String getName();
	
	public void joinGame();
	
	public void leaveGame();
	
	public void startTurn();

	public void endTurn();
	
//	public YahtzoidCard drawCard();
	
	public boolean assignHand();
	
	public void assignPlayedCard(Card card);
	
	public Dice[] rollDice(int howMany, boolean isMagic);

}
