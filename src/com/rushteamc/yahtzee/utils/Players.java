
package com.rushteamc.yahtzee.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Runnetty
 */

public class Players {
    
    public static List PlayerNames = new ArrayList<>();
    
    // To get a players name from the list type:
    // PlayerNames.get(<the player nr id>)
    
    public static void CreatePlayers(){ //Adds names to the list.
     
        PlayerNames.add("Runnetty");
        PlayerNames.add("Allistar");
        PlayerNames.add("Eivind");
        PlayerNames.add("Anamorphic");
    }
    
    public static void GetAllPlayerNames() //Gets all names and puts in string called AllPlayers.
    { 
        int Nrplayrs = PlayerTurnCheck.NrPlyrs;
        for(int a = 0; a <= Nrplayrs-1; a++){ 
            int b = a;
            String AllPlayers = (String) PlayerNames.get(b);
            System.out.print(AllPlayers+ ", "); 
        }
        System.out.println();
        
        if(PlayerNames.isEmpty()) //Checks if the list is empty, if true print error.
        {
            System.err.println("Theres no player names in the list");
        }
        
    }
    
    public static void DeleteAllPlayerNames() //Self Explainatory.
    {
        PlayerNames.removeAll(PlayerNames);
        System.out.println("All Players Deleted");
    }
    
    
    
}
