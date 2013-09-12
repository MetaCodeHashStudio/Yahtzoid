package com.rushteamc.yahtzee.utils;

import java.util.Random;

public class RollDie
{
	public static int[] castDie() // rolls the die and returns the array.
	{
		Random Dice = new Random();
		int[] CastDie = new int[5];
		for
		(
			int i = 0;
				i < CastDie.length;
				i++
		)
		{
			CastDie[i] = (Dice.nextInt(6)+1);
			System.out.println("Dice number " +  (i + 1) + " has been cast and returned " + CastDie[i]);
		}
		return CastDie;
	}
}
