package com.rushteamc.yahtzee.utils;

import java.util.Random;

public class RollDice
{
	public static int[] castDice() // rolls the die and returns the array.
	{
		int DieSize = com.rushteamc.yahtzee.utils.Configurables.getDieSize();		// How many faces on the rolled die?
		int HowManyDice = com.rushteamc.yahtzee.utils.Configurables.getDieNumber();	// How many dice to roll?
		Random Die = new Random();
		int[] Dice = new int[HowManyDice];
		for
		(
			int i = 0;
				i < Dice.length;
				i++
		)
		{
			Dice[i] = (Die.nextInt(DieSize)+1);
			System.out.println("Die number " +  (i + 1) + " has been cast and returned " + Dice[i]);
		}
		return Dice;
	}
}
