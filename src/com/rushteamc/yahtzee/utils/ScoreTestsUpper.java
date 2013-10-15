package com.rushteamc.yahtzee.utils;

public class ScoreTestsUpper
{
	public static int checkUpper(int CheckFor)
	{
		int Score = 0;
		CheckFor++;
		int[] dice = Variables.diceArray;
		for
		(
				int i = 0;
					i < dice.length;
					i++
		)
		{
			if(dice[i] == CheckFor)
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
