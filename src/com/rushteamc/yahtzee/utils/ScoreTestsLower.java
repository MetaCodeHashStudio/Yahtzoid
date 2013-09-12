package com.rushteamc.yahtzee.utils;

public class ScoreTestsLower
{
	public static int checkForThreeOfAKind(int[] Values)
	{
		int Score = 0;
		for
		(
			int i = 0;
				i < Values.length;
				i++
		)
		{
			if(Values[i] >= 3)
			{
				Score = 3*(i+1);
			}
		}
		System.out.println("Returning " + Score + " for three of a kind.");
		return Score;
	}
	public static int checkForFourOfAKind(int[] Values)
	{
		int Score = 0;
		for
		(
			int i = 0;
				i < Values.length;
				i++
		)
		{
			if(Values[i] >= 4)
			{
				Score = 4*(i+1);
			}
		}
		System.out.println("Returning " + Score + " for four of a kind.");
		return Score;
	}
	public static int checkForFullHouse(int[] Values)
	{
		int Score = 0;
		boolean Three = false;
		boolean Two = false;
		for
		(
			int i = 0;
				i < Values.length;
				i++
		)
		{
			if(Values[i] == 3)
			{
				Three = true;
			}
			if(Values[i] == 2)
			{
				Two = true;
			}
		}
		if(Three && Two)
		{
			Score = 25;
		}
		System.out.println("Returning " + Score + " for full house.");
		return Score;
	}
	public static int checkForSmallStraight(boolean Numbers[])
	{
		int Score = 0;
		if
		(
				Numbers[0]
			 && Numbers[1]
			 && Numbers[2]
			 && Numbers[3]
		)
		{
			Score = 30;
		}
		else if
		(
				Numbers[1]
			 && Numbers[2]
			 && Numbers[3]
			 && Numbers[4]
		)
		{
			Score = 30;
		}
		else if
		(
				Numbers[2]
			 && Numbers[3]
			 && Numbers[4]
			 && Numbers[5]
		)
		{
			Score = 30;
		}
		System.out.println("Returning " + Score + " for small straight.");
		return Score;
	}
	public static int checkForLargeStraight(boolean[] Numbers)
	{
		int Score = 0;
		if
		(
				Numbers[0]
			 && Numbers[1]
			 && Numbers[2]
			 && Numbers[3]
			 && Numbers[4]
		)
		{
			Score = 40;
		}
		else if
		(
				Numbers[1]
			 && Numbers[2]
			 && Numbers[3]
			 && Numbers[4]
			 && Numbers[5]
		)
		{
			Score = 40;
		}
		System.out.println("Returning " + Score + " for large straight.");
		return Score;
	}
	public static int checkForYahtzee(int Values[])
	{
			int Score = 0;
			for
			(
				int i = 0;
					i < Values.length;
					i++
			)
			{
				if(Values[i] == 5)
				{
					Score = 50;
				}
			}
			System.out.println("Returning " + Score + " for yahtzee.");
			return Score;
	}
	public static int checkForChance(int Values[])
	{
		int Score = 0;
		for
		(
			int i = 0;
				i < Values.length;
				i++
		)
		{
			Score += Values[i]*(i+1);
		}
		System.out.println("Returning " + Score + " for chance.");
		return Score;
	}
}
