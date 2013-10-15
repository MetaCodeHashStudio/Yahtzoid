package com.rushteamc.yahtzee.utils;

import com.rushteamc.yahtzee.dice.Dice;

public class DieCounter
{

	public static int[] countValues(Dice[] dice, int howMany)
	{
		
//		int DieSize = com.rushteamc.yahtzee.utils.Configurables.getDieSize();
		int[] Values = new int[howMany];
		for
		(
			int i = 0;
				i < howMany; // For every value in the array.
				i++
		)
		{
			for
			(
				int j = 1;
					j <= dice[i].getSize(); // For every possible dice face.
					j++
			)
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
	
	public static boolean[] truthValues(Dice[] dice, int howLarge, int howMany)		// Used for the Straight checks.
	{
		boolean[] Numbers = new boolean[howLarge];
		for(int i = 0 ; i < howMany ; i++)
		{
			for(int j = 1 ; j <= dice[i].getSize() ; j++)
			{
				if(dice[i].getValue(j))
					Numbers[i] = true;
			}
		}
		return Numbers;
		
	}
	
}
