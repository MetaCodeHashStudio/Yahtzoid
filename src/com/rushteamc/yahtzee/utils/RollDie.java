package com.rushteamc.yahtzee.utils;

import java.util.Random;

public class RollDie
{
	public static int[] castDie() // rolls the die and returns the array.
	{
		int DieSize = com.rushteamc.yahtzee.utils.Configurables.getDieSize();
		int HowManyDice = com.rushteamc.yahtzee.utils.Configurables.getDieNumber();
		Random Dice = new Random();
		int[] CastDie = new int[HowManyDice];
		for
		(
			int i = 0;
				i < CastDie.length;
				i++
		)
		{
			CastDie[i] = (Dice.nextInt(DieSize)+1);
			System.out.println("Dice number " +  (i + 1) + " has been cast and returned " + CastDie[i]);
		}
		return CastDie;
	}
}
