package com.rushteamc.yahtzee.utils;

import com.rushteamc.yahtzee.dice.Dice;

public class ScoreTestsLower
{
	public static int checkForXOfAKind(int X, Dice[] dice)
	{
		int[] Values = DieCounter.countValues(dice);
		int Score = 0;
		for
		(
			int i = 0;
				i < Values.length;
				i++
		)
		{
			if(Values[i] >= X)
				Score = X*(i+1);
		}
		System.out.println("Returning " + Score + " for " + X + " of a kind.");
		return Score;
	}
	public static int checkForPair(Dice[] dice)
	{
		int[] Values = DieCounter.countValues(dice);
		int Score = 0;
		for(int i = 0 ; i < Values.length ; i++)
		{
			if(Values[i] >= 2)
				Score = 2*(i+1);
		}
		
		return Score;
	}
	public static int checkForTwoPairs(Dice[] dice)
	{
		int Score = 0;
		int[] Values = DieCounter.countValues(dice);
		boolean AlreadyHavePair = false;
		boolean ReturnScore = false;
		for(int i = 0 ; i < Values.length ; i++)
		{
			if(Values[i] >= 2)
			{
				if(AlreadyHavePair)
				{
					Score += 2*(i+1);
					ReturnScore = true;
				}
				else
				{
					AlreadyHavePair = true;
					Score = 2*(i+1);
				}
			}
				
		}
		if(ReturnScore)
			return Score;
		else return 0;
	}
	/*
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
	*/
	public static int checkForFullHouse(Dice[] dice)
	{
		int[] Values = DieCounter.countValues(dice);
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
	public static int checkForSmallStraight(Dice[] dice)
	{
		/*	This method should be deprecated or rewritten. Does not support configurable die sizes. */
		boolean[] Numbers = DieCounter.truthValues(dice);
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
	public static int checkForLargeStraight(Dice[] dice)
	{
		/*	This method should be deprecated or rewritten. Does not support configurable die sizes. */
		boolean[] Numbers = DieCounter.truthValues(dice);
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
	public static int checkForYahtzee(Dice[] dice)
	{
		int[] Values = DieCounter.countValues(dice);
		int Score = 0;
		for(int i = 0 ; i < Values.length ;	i++)
			{
				if(Values[i] == 5)
				{
					Score = 50;
				}
			}
			System.out.println("Returning " + Score + " for yahtzee.");
			return Score;
	}
	public static int checkForChance(Dice[] dice)
	{
		int howMany = DieCounter.getActives(dice);
		int Score = 0;
		for(int i = 0;	i < howMany;	i++)
		{
			Score += dice[i].getValue();
		}
		System.out.println("Returning " + Score + " for chance.");
		return Score;
	}
}
