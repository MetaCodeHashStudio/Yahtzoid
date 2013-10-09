package com.rushteamc.yahtzee.utils;

import com.rushteamc.yahtzee.gui.handlers.TimerHandler;
import static com.rushteamc.yahtzee.utils.Variables.playerNames;

/**
 * @author Runnetty
 */
public class PlayerTurnCheck {
    
        public static int NrPlyrs = Variables.playerNames.size(); //Set how many Players that will play. cannot be moved!
        public static String[] Playersstring = new String[NrPlyrs]; //cannot be moved!
        
    public static void CheckForRoundEnd()
    {   
        
        /*Checks if Curent Turn is greater than the number of players*/
        /////////////////////////////////////////////////////////////
            for(int MaxTurns = NrPlyrs; Variables.turnNumber > MaxTurns;)
        {
            System.out.println("The current round is finished");
            Variables.roundNumber++;
            Variables.turnNumber=1;
        }
        /////////////////////////////////////////////////////////////
    }
    
    public static void PrintPlayerTurn()
    {
        if(!Variables.playerNames.isEmpty())
        {
            String Pname = (String) Variables.playerNames.get(Variables.turnNumber-1);
            Variables.currentPlayer = "Its "+Pname + "'s Turn"+" on round: " + Variables.roundNumber;
            System.out.println(Variables.currentPlayer); 
        
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
        Variables.totalPlayers = "There are: "+Playersstring.length+ " players";
        System.out.println(Variables.totalPlayers);   
        
    }
    
     public static void NextTurn() throws InterruptedException
    {
        Variables.turnNumber++; //Adds 1 to Current Turn 
        CheckForRoundEnd();
        PrintPlayerTurn();
        //TimerHandler.TurnTime90();
        
        
    }

}