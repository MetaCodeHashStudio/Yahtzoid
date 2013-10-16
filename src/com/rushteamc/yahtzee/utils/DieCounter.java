package com.rushteamc.yahtzee.utils;

import com.rushteamc.yahtzee.dice.Dice;

public class DieCounter
{

	public static int[] countValues(Dice[] dice)
	{
		
		int howMany;
		if(dice[5].getActive())
			howMany = 6;
		else howMany = 5;
		int[] Values = new int[dice[0].getSize()];
		for
		(int i = 0 ; i < howMany ; i++
		)
		{
			for
			(int j = 1 ; j <= dice[i].getSize() ; j++)
			{
				if
				(
				dice[i].getValue(j)       // If dice number i is equal to the value of j.
				)
				{
					Values[(j-1)]++;		// Add 1 to the value of the die face.
				}
			}
		}
		return Values;
	}
	public static int getActives(Dice[] dice)
	{
		int howMany;
		
		if(dice[Variables.BONUS_DIE_NUMBER-1].getActive())
			howMany = Variables.BONUS_DIE_NUMBER;
		else howMany = Variables.STANDARD_NUMBER_OF_DICE;
		
		return howMany;
	}
	
	public static boolean[] truthValues(Dice[] dice)		// Used for the Straight checks.
	{
		int howMany = getActives(dice);
		int howLarge = dice[0].getSize();
		boolean[] Numbers = new boolean[howLarge];
		for(int i = 0 ; i < howLarge ; i++)
		{
			Numbers[i] = false; // Pre-init
		}
		for(int i = 0 ; i < howMany ; i++)
		{
			int index = dice[i].getValue()-1;
			Numbers[index] = true;
		}
		return Numbers;
		
	}
	
}
