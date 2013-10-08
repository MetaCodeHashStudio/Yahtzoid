package com.rushteamc.yahtzee.utils;

import java.util.Random;

import com.rushteamc.yahtzee.utils.Variables;

public class RollDice
{
	public static int[] castDice() // rolls the die and returns the array.
	{
		int DieSize = Variables.standardDieSize;		// How many faces on the rolled die?
		int HowManyDice = Variables.standardNumberOfDice;	// How many dice to roll?
		Random Die = new Random();													// The die is a random value. :p
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
		Variables.diceArray = Dice;
		return Dice;
	}
}
