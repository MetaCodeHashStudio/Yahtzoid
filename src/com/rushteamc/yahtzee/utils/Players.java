
package com.rushteamc.yahtzee.utils;



/**
 * @author Runnetty
 */

public class Players {

    // To get a speciffic player name from the list, type:
    // Variables.PlayerNames.get(<the player nr id>)
    
    public static void createPlayers(){ //Adds names to the list.
        
        /*Test adds*/
        Variables.playerNames.add("Runnetty");
        Variables.playerNames.add("Allistar");
        Variables.playerNames.add("Eivind");
        Variables.playerNames.add("Anamorphic");
        /*Test adds*/
        
        /*Needs to get string from GUI input field*/
    }
    
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
