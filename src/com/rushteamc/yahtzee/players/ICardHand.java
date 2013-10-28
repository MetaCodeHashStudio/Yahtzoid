package com.rushteamc.yahtzee.players;

public interface ICardHand {

	public YahtzoidCard[] checkHand();
	
	public YahtzoidCard drawCard();
	
	public void placeInHand(YahtzoidCard card);
	
	public void discardCard();
	
	
	
}
