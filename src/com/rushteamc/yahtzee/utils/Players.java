
package com.rushteamc.yahtzee.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Runnetty
 */

public class Players {

    // To get a speciffic player name from the list, type:
    // Variables.PlayerNames.get(<the player nr id>)
    
    public static void createPlayers(){ //Adds names to the list.
        
        /*Test adds*/
        Variables.PlayerNames.add("Runnetty");
        Variables.PlayerNames.add("Allistar");
        Variables.PlayerNames.add("Eivind");
        Variables.PlayerNames.add("Anamorphic");
        /*Test adds*/
        
        /*Needs to get string from GUI input field*/
    }
    
    public static void getAllPlayerNames() //Gets all names and puts in string called AllPlayers.
    { 
        int Nrplayrs = Variables.PlayerNames.size();
        
        for(int a = 0; a <= Nrplayrs-1; a++)
        { 
            int b = a;
            Variables.AllPlayers = (String) Variables.PlayerNames.get(b);
            System.out.print(Variables.AllPlayers+ ", "); 
        }
        
        System.out.println();
       
    }
    
    public static void deleteAllPlayerNames() //Self Explainatory.
    {
        Variables.PlayerNames.removeAll(Variables.PlayerNames.subList(0, Variables.PlayerNames.size()));
        
        if(!Variables.PlayerNames.isEmpty()) //Checks if the list is empty, if true print error.
        {
            System.out.println("Theres no player names in the list to delete");
        }
        else
        {
        	System.out.println("All Players Deleted");
        }
        
    }
    
 
}
