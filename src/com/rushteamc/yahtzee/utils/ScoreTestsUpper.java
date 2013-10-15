package com.rushteamc.yahtzee.utils;

import com.rushteamc.yahtzee.dice.Dice;

public class ScoreTestsUpper
{
	public static int checkUpper(int CheckFor)
	{
		int Score = 0;
		CheckFor++;
		Dice[] dice = Variables.dice;
		for
		(
				int i = 0;
					i < dice.length;
					i++
		)
		{
			if(dice[i].getValue() == CheckFor)
			{
				Score += CheckFor;
			}
		}
		System.out.println("Returning " + Score + " points for " + CheckFor + " values.");
		return Score;
	}
	public static int checkForBonus(int ScoreUpper)
	{
		int Score = 0;
		int ScoreRequired = 63;
		if(ScoreUpper >= ScoreRequired)
		{
			Score = 35;
		}
		
		return Score;
	}
}
