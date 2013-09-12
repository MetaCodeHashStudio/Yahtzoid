package com.rushteamc.yahtzee.utils;

public class DieCounter
{

	public static int[] countValues(int Dice[])
	{
		int DieSize = com.rushteamc.yahtzee.utils.Configurables.getDieSize();
		int[] Values = new int[Dice.length];
		for
		(
			int i = 0;
				i < Dice.length; // For every value in the array.
				i++
		)
		{
			for
			(
				int j = 1;
					j <= DieSize; // For every possible dice face.
					j++
			)
			{
				if
				(
				Dice[i] == j
				)
				{
					Values[(j-1)] += 1;
				}
			}
		}
		return Values;
	}
	public static boolean[] truthValues(int Values[])
	{
		int DieSize = com.rushteamc.yahtzee.utils.Configurables.getDieSize();
		boolean[] Numbers = new boolean[DieSize]; // Boolean array. Returns true if the values array contains a number value.
		for
		(
			int i = 0;
				i < Numbers.length;
				i++
		)
		{
			if(Values[i] >= 1)
			{
				Numbers[i] = true;
				System.out.println("The values do contain a " + (i+1));
			}
			else
			{
				Numbers[i] = false;
			}
		}
		return Numbers;
	}
}
