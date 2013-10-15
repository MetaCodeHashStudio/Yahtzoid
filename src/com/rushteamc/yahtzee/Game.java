package com.rushteamc.yahtzee;

/*
 * Class Game should not contain any references to GUI-code directly. If this class must be tied to GUI code,
 * then you should try to start methods contained in this class using return values in the GUI's handlers.
 * If all else fails, insert the following comment:
 */
 		/*          */
  		/*GUIMETHOD */
        /*          */
import com.rushteamc.yahtzee.utils.PlayerTurnCheck;
import com.rushteamc.yahtzee.utils.ScoreTestsUpper;
import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.dice.Dice;
public class Game
{
	public static void startGame()
	{
		
	}
	public static int checkForScore(int index, int[] dice)
	{
		String scoreToCheck = Variables.scoreTypes[index];
		System.out.println("Checking score for " + scoreToCheck);
		boolean continueChecking = true;
		int n = 0;
		int scoreToInsert = 0;
		while(continueChecking && n < 6)
		{
			if(scoreToCheck == Variables.upperTypes[n])
			{
				continueChecking = false;
				scoreToInsert = ScoreTestsUpper.checkUpper(n);
			}
			
			n++;
		}
		/*
		 * Game logic for score checking. index points to which check, dice are the active dice values.
		 */
		return scoreToInsert;
	}
	public static void endTurn() throws InterruptedException
	{
		/*
		 * This method should be called to end the current player's turn after inputting his points.
		 */
            PlayerTurnCheck.NextTurn();
            
	}
        
        //EndRound Handeled allready by PlayerTurnCheck
        
	public static void endGame()
	{
		/*
		 * This method should be called when the last turn on the last round ends.
		 */
	}
	public static void saveGame()
	{
		/*
		 * This method should be called to dump all variables needed for loadGame() to carry off at the exact same position as it was in.
		 */
	}
	public static void loadGame()
	{
		/*
		 * This method should be called to populate all variables from a saved file. Do not call GUI elements from this method, ONLY populate variables.
		 */
	}
}
