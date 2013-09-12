package com.rushteamc.yahtzee;

import com.rushteamc.yahtzee.utils.PlayerTurnCheck;

public class Start
{

	public static void main(String[] args)
	{
              //PlayerTurnCheck.CheckForPlayerTurn(); // Jumps to next Player in turn on current round. If the round is done it Restarts turns and adds one to round.
              //PlayerTurnCheck.PrintPlayerTurn();// Just Prints Curent Players Turn and Wich Round
		int[] Die = com.rushteamc.yahtzee.utils.RollDie.castDie();
		int[] Values = com.rushteamc.yahtzee.utils.DieCounter.countValues(Die);
		boolean[] Numbers = com.rushteamc.yahtzee.utils.DieCounter.truthValues(Values);
		int Score = 0;
		int ScoreUpper = 0;
		for
		(
			int i =1;
				i <= 6;
				i++
		)
		{
			ScoreUpper += com.rushteamc.yahtzee.utils.ScoreTestsUpper.checkUpper(Die, i);
		}
		Score += ScoreUpper;
		Score += com.rushteamc.yahtzee.utils.ScoreTestsUpper.checkForBonus(ScoreUpper);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForThreeOfAKind(Values);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForFourOfAKind(Values);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForFullHouse(Values);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForSmallStraight(Numbers);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForLargeStraight(Numbers);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForChance(Values);
		debugDie(Die, Values);
		
		System.out.println("Total score: " + Score);
	}
	public static void debugDie(int[] Die, int[] Values)
	{
		System.out.println("Die array looks like: ");
		for
		(
			int i = 0;
				i < Die.length;
				i++
		)
		{
			System.out.print(Die[i] + " ");
		}
		System.out.println();
		System.out.println("The values array now looks like: ");
		System.out.println("1\t2\t3\t4\t5\t6");
		for (int k = 0; k < Values.length; k++)
		{
			System.out.print(Values[k] + "\t");
		}
		System.out.println();
	}

}
