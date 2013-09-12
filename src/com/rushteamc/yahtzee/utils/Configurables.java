package com.rushteamc.yahtzee.utils;

public class Configurables
{
	
	public static int getDieSize()
	
	{	
		
		int DieSize = 6;				// Specify the amount of faces on the die.
		return DieSize;
		
	}
	
	public static int getDieNumber()
	
	{
		
		int NumberOfDice = 5;			// Specify how many dice are active each turn.
		return NumberOfDice;
		
	}
	
	public static int minScoreForBonus()
	{
		int ScoreForBonus = 63;			// Specify how many points in the Upper Section are required for Bonus.
		return ScoreForBonus;
	}
}
