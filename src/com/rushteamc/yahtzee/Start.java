package com.rushteamc.yahtzee;

import com.rushteamc.yahtzee.utils.PlayerTurnCheck;
import com.rushteamc.yahtzee.utils.Players;

public class Start
{

	public static void main(String[] args) throws InterruptedException
	{
		/*
		 * Dummy main method for debugging until we start implementing functions!
		 */
                Players.CreatePlayers();
                PlayerTurnCheck.TotalPlayingPlayers();	// Will Output Total Players
                Players.GetAllPlayerNames();

                PlayerTurnCheck.PrintPlayerTurn();		// Just Prints Curent Players Turn and game Round
                PlayerTurnCheck.NextTurn();				// Next Players Turn :D
                
                
		int[] Dice = com.rushteamc.yahtzee.utils.RollDice.castDice(); 						// Init and populate Dice array with random numbers.
		int[] Values = com.rushteamc.yahtzee.utils.DieCounter.countValues(Dice); 			// Turn the useless dice array into useful values.
		boolean[] Numbers = com.rushteamc.yahtzee.utils.DieCounter.truthValues(Values);		// Create booleans for whether or not a number is present.
		int Score = 0;		// Preinit.
		int ScoreUpper = 0;	// Preinit.
		for
		(
			int i =1;
				i <= com.rushteamc.yahtzee.utils.Configurables.getDieSize();				// For every face on the dice:
				i++
		)
		{
			ScoreUpper += com.rushteamc.yahtzee.utils.ScoreTestsUpper.checkUpper(Dice, i);	// Multiply values with amounts and get points! :D
		}
		Score += ScoreUpper;	// Add ScoreUpper to total score.
		Score += com.rushteamc.yahtzee.utils.ScoreTestsUpper.checkForBonus(ScoreUpper);		// Check if ScoreUpper qualifies for bonus points!
		/* 
		 * Self explanatory below.
		 */
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForThreeOfAKind(Values);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForFourOfAKind(Values);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForFullHouse(Values);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForSmallStraight(Numbers);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForLargeStraight(Numbers);
		Score += com.rushteamc.yahtzee.utils.ScoreTestsLower.checkForChance(Values);
		/*
		 *  End self-explanatory. Start debug.
		 */
		debugDie(Dice, Values);
		
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
		for (int i = 1; i <= com.rushteamc.yahtzee.utils.Configurables.getDieSize(); i++)
		{
			System.out.print(i+"\t");
		}
		System.out.println();
		for (int k = 0; k < com.rushteamc.yahtzee.utils.Configurables.getDieSize(); k++)
		{
			System.out.print(Values[k] + "\t");
		}
		System.out.println();
	}

}
