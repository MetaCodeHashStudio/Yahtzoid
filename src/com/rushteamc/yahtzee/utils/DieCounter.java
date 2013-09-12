package com.rushteamc.yahtzee.utils;

public class DieCounter
{

	public static int[] countValues(int Dice[])
	{
		int DieSize = com.rushteamc.yahtzee.utils.Configurables.getDieSize(); // No need to use this method here.
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
				Dice[i] == j      // If dice number i is equal to the value of j.
				)
				{
					Values[(j-1)] += 1;		// Add 1 to the value of the die face.
				}
			}
		}
		return Values;
	}
	public static boolean[] truthValues(int Values[])		// Used for the Straight checks.
	{
		int DieSize = com.rushteamc.yahtzee.utils.Configurables.getDieSize(); // Configures size of the array.
		boolean[] Numbers = new boolean[DieSize]; // Boolean array. Returns true if the values array contains a number value.
		for
		(
			int i = 0;
				i < Numbers.length;
				i++
		)
		{
			if(Values[i] >= 1)		// If there is at least one die with the value i
			{						//
				Numbers[i] = true;	// Set the boolean for the value i to true.
				System.out.println("The values do contain a " + (i+1));
			}
			else
			{
				Numbers[i] = false; // If not, make sure it's false. (Think it's pre-init to false?)
			}
		}
		return Numbers;	// Sends the truth array back!
	}
}
