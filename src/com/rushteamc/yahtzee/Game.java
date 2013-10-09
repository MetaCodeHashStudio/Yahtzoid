package com.rushteamc.yahtzee;

/*
 * Class Game should not contain any references to GUI-code directly. If this class must be tied to GUI code,
 * then you should try to start methods contained in this class using return values in the GUI's handlers.
 * If all else fails, insert the following comment:
 */
 		/*          */
  		/*GUIMETHOD */
        /*          */

public class Game
{
	public static void startGame()
	{
		/*
		 * This method should be called to start all game logic -after- every GUI element has been built.
		 */
	}
	public static int checkForScore(int index, int[] dice)
	{
		int scoreToInsert = 0;
		/*
		 * Game logic for score checking. index points to which check, dice are the active dice values.
		 */
		return scoreToInsert;
	}
	public static void endTurn()
	{
		/*
		 * This method should be called to end the current player's turn after inputting his points.
		 */
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
