package com.rushteamc.yahtzee.utils;

import static com.rushteamc.yahtzee.utils.Variables.PlayerNames;

/**
 * @author Runnetty
 */
public class PlayerTurnCheck {
    
        public static int NrPlyrs = Variables.PlayerNames.size(); //Set how many Players that will play. cannot be moved!
        public static String[] Playersstring = new String[NrPlyrs]; //cannot be moved!
        
    public static void CheckForRoundEnd()
    {   
        
        /*Checks if Curent Turn is greater than the number of players*/
        /////////////////////////////////////////////////////////////
            for(int MaxTurns = NrPlyrs; Variables.Turn > MaxTurns;)
        {
            System.out.println("The current round is finished");
            Variables.Round++;
            Variables.Turn=1;
        }
        /////////////////////////////////////////////////////////////
    }
    
    public static void PrintPlayerTurn()
    {
        if(!Variables.PlayerNames.isEmpty())
        {
            String Pname = (String) Variables.PlayerNames.get(Variables.Turn-1);
            Variables.Curplayer = "Its "+Pname + "'s Turn"+" on round: " + Variables.Round;
            System.out.println(Variables.Curplayer); 
        
        }else{
            System.out.println(); 
            System.out.println("////////////W A R N I N G ////////////"); //BTW this cant be "System.err..."
            System.out.println("Theres no player names in the list!");
            System.out.println("//////////////////////////////////////");
            System.out.println();  
        }
    }
    
     public static void TotalPlayingPlayers()
             
    {
        Variables.TotalPlayers = "There are: "+Playersstring.length+ " players";
        System.out.println(Variables.TotalPlayers);   
        
    }
    
     public static void NextTurn()
    {
        Variables.Turn++; //Adds 1 to Current Turn 
        CheckForRoundEnd();
        PrintPlayerTurn();
    }

}