
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
    
    public static void CreatePlayers(){
     
        PlayerNames.add("Runnetty");
        PlayerNames.add("Allistar");
        PlayerNames.add("Eivind");
        PlayerNames.add("Anamorphic");
    }
    
    public static void GetAllPlayerNames() throws InterruptedException{
        int Nrplayrs = PlayerTurnCheck.NrPlyrs;
        for(int a = 0; a <= Nrplayrs-1; a++){ 
            int b = a;
            String AllPlayers = (String) PlayerNames.get(b);
            System.out.print(AllPlayers+ ", "); 
        }
        System.out.println();
        
    }
    
    
    
}
