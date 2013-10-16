
package com.rushteamc.yahtzee.utils;



/**
 * @author Runnetty
 */

public class Players {

    public static void getAllPlayerNames() //Gets all names and puts in string called AllPlayers.
    { 
        int Nrplayrs = Variables.playerNames.size();
        
        for(int a = 0; a <= Nrplayrs-1; a++)
        { 
            int b = a;
            Variables.allPlayers = (String) Variables.playerNames.get(b);
            System.out.print(Variables.allPlayers+ ", "); 
        }
        
        System.out.println();
       
    }
    public static int getLastPlayerIndex()
    {
    	int lastPlayer = Variables.selectedNumPlayers - 1;
    	
    	return lastPlayer;
    }
    public static void deleteAllPlayerNames() //Self Explainatory.
    {
        Variables.playerNames.removeAll(Variables.playerNames.subList(0, Variables.playerNames.size()));
        
        if(!Variables.playerNames.isEmpty()) //Checks if the list is empty, if true print error.
        {
            System.out.println("Theres no player names in the list to delete");
        }
        else
        {
        	System.out.println("All Players Deleted");
        }
        
    }
    
 
}
