package com.rushteamc.yahtzee.utils;

public class ScoreTestsUpper
{
	public static int checkUpper(int[] Die, int CheckFor)
	{
		int Score = 0;
		for
		(
				int i = 0;
					i < Die.length;
					i++
		)
		{
			if(Die[i] == CheckFor)
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
		
		if(ScoreUpper >= 63)
		{
			Score = 35;
		}
		
		return Score;
	}
}
