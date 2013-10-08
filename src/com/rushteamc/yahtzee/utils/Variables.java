
package com.rushteamc.yahtzee.utils;

import java.util.ArrayList;

public class Variables {
    
				public static final String APPLICATION_TITLE = "Yahtzoid Version -1"; 
				public static final int MAX_SUPPORTED_PLAYERS = 4;
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
				
				// SCORE VARIABLES //
				public static int ScoreForBonus = 63;
				
        /////////// - I N T - ////////////
            /*PlayerTurnCheck.class*/
                public static int turnNumber = 1; 	// Pre-init
                public static int roundNumber = 1;	// Pre-init

        /////////// - S T R I N G - ////////////
            /*PlayerTurnCheck.class*/
                public static String curPlayer; // Will Output Current Player on round
                public static String totalPlayers; // Will Output Total Players 
                public static String allPlayers;
        /////////// - B O O L E A N - ////////////
        
        /////////// - F L O A T - ////////////
        
        /////////// - A R R A Y S - ////////////
            /*Players.class*/    
                public static ArrayList<String> playerNames = new ArrayList<>(); //Creates a player list array.
        

}
