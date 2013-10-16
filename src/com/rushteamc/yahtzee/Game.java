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
import com.rushteamc.yahtzee.utils.ScoreTestsLower;
import com.rushteamc.yahtzee.utils.ScoreTestsUpper;
import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.dice.Dice;
public class Game
{
	public static void startGame()
	{
		
		//Start building dice array
		Dice[] dice = new Dice[7];
		for(int i = 0 ; i < 5 ; i++)
		{
			dice[i] = new Dice(6);
		}
		dice[5] = new Dice(6);
		dice[5].setActive(false);
		dice[6] = new Dice(8);
		dice[6].setActive(false);
		
		System.out.println(dice[0].getValue());
		System.out.println(dice[0].getSize());
		Variables.dice = dice;
		//Save dice
		
		//Start building score booleans
		boolean[][] addedScores = new boolean[Variables.selectedNumPlayers][Variables.scoreTypes.length];
		for(int i = 0 ; i < Variables.selectedNumPlayers ; i++)
			for(int j = 0 ; j < Variables.scoreTypes.length ; j++)
			{
				addedScores[i][j] = false;
			}
		Variables.playerHasAddedScore = addedScores;
	}
	public static int checkForScore(int index, Dice[] dice)
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
		if(continueChecking)
		{
				if(scoreToCheck == "Pair")
					scoreToInsert = ScoreTestsLower.checkForPair(dice);
				if(scoreToCheck == "Two Pairs")
					scoreToInsert = ScoreTestsLower.checkForTwoPairs(dice);
				if(scoreToCheck == "Three of a Kind")
					scoreToInsert = ScoreTestsLower.checkForXOfAKind(3, dice);
				if(scoreToCheck == "Four of a Kind")
					scoreToInsert = ScoreTestsLower.checkForXOfAKind(4, dice);
				if(scoreToCheck == "Small Straight")
					scoreToInsert = ScoreTestsLower.checkForSmallStraight(dice);
				if(scoreToCheck == "Large Straight")
					scoreToInsert = ScoreTestsLower.checkForLargeStraight(dice);
				if(scoreToCheck == "Full House")
					scoreToInsert = ScoreTestsLower.checkForFullHouse(dice);
				if(scoreToCheck == "Chance")
					scoreToInsert = ScoreTestsLower.checkForChance(dice);
				if(scoreToCheck == "Yahtzee")
					scoreToInsert = ScoreTestsLower.checkForYahtzee(dice);
		}
		/*
		 * Game logic for score checking. index points to which check, dice are the active dice values.
		 */
		return scoreToInsert;
	}
	public static int endTurn() throws InterruptedException
	{
		/*
		 * This method should be called to end the current player's turn after inputting his points.
		 */
		int playerNumber = 0;

        playerNumber = PlayerTurnCheck.NextTurn();

		return playerNumber;
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
