
package com.rushteamc.yahtzee.utils;

import java.util.ArrayList;

public class Variables {
    
				public static final String APPLICATION_TITLE = "Yahtzoid Version -1"; 
				public static final int MAX_SUPPORTED_PLAYERS = 4;
				public static final int STANDARD_MAX_REROLLS = 2;
				public static int currentUsedRerolls = -1; //pre-init
				public static int standardDieSize = 6;
				public static int standardNumberOfDice = 5;
				public static int[] diceArray;
				public static boolean[] dieHeld = new boolean[standardNumberOfDice+1];
				public static int selectedNumPlayers = 0;	// Pre-init to 0 for rudamentary error checking.
				public static final String scoreTypes[] =
					{
						"Aces",
						"Twos",
						"Threes",
						"Fours",
						"Fives",
						"Sixes",
						"Upper Total",
						"Bonus",
						"Pair",
						"Two Pairs",
						"Three of a Kind",
						"Four of a Kind",
						"Small Straight",
						"Large Straight",
						"Full House",
						"Chance",
						"Yahtzee",
						"Lower Total",
						"Grand Total"
					};
				public static final String upperTypes[] =
					{
						scoreTypes[0],
						scoreTypes[1],
						scoreTypes[2],
						scoreTypes[3],
						scoreTypes[4],
						scoreTypes[5]
					};
				
				// SCORE VARIABLES //
				public static int ScoreForBonus = 63;
				
				
				// FILE HANDLING //
				public static String internalFilePath;
        /////////// - I N T - ////////////
            /*PlayerTurnCheck.class*/
                public static int turnNumber = 0; 	// Pre-init
                public static int roundNumber = 1;	// Pre-init

        /////////// - S T R I N G - ////////////
            /*PlayerTurnCheck.class*/
                public static String currentPlayer; // Will Output Current Player on round
                public static String totalPlayers; // Will Output Total Players 
                public static String allPlayers;
        /////////// - B O O L E A N - ////////////
        
        /////////// - F L O A T - ////////////
        
        /////////// - A R R A Y S - ////////////
            /*Players.class*/    
                public static ArrayList<String> playerNames = new ArrayList<>(); //Creates a player list array.
        

}
