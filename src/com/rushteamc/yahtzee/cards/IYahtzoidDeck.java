package com.rushteamc.yahtzee.cards;

public interface IYahtzoidDeck {

	public void buildDeck();
	
	public YahtzoidCard drawCard();

	public void shuffleDeck();
	
	public YahtzoidCard checkTop();
	
	public void insertToBottom(YahtzoidCard cardToInsert);
	
	public void dispose();
	
}
