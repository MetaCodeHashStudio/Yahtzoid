
package com.rushteamc.yahtzee.utils;

import java.util.ArrayList;
import java.util.List;

public class Variables {
    
				public static final int MAX_SUPPORTED_PLAYERS = 4;
				public static boolean[] radioIsSelected = new boolean[MAX_SUPPORTED_PLAYERS];
				public static int selectedNumPlayers = 0;	// Pre-init to 0 for rudamentary error checking.
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
                public static List playerNames = new ArrayList<>(); //Creates a player list array.
        

}
