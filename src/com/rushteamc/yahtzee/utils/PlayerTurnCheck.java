package com.rushteamc.yahtzee.utils;

import com.rushteamc.yahtzee.Game;


/**
 * @author Runnetty
 */
public class PlayerTurnCheck {
    
        public static int NrPlyrs = Variables.playerNames.size(); //Set how many Players that will play. cannot be moved!
        public static String[] Playersstring = new String[NrPlyrs]; //cannot be moved!
        
    public static boolean CheckForRoundEnd()
    {
    	boolean preventRearm = false;
        
        /*Checks if Curent Turn is greater than the number of players*/
        /////////////////////////////////////////////////////////////
    	for(int MaxTurns = NrPlyrs; Variables.turnNumber > MaxTurns-1;)
    	{
        	System.out.println("The current round is finished");
         	Variables.roundNumber++;
            if(Variables.roundNumber > (Variables.scoreTypes.length - 4))
            {
            	Game.endGame();
            	preventRearm = true;
            }
            else
            {
            	Variables.turnNumber=0;
            	preventRearm = false;
            }
        }
    	return preventRearm;
        /////////////////////////////////////////////////////////////
    }
    
    public static void PrintPlayerTurn()
    {
        if(!Variables.playerNames.isEmpty())
        {
            String Pname = (String) Variables.playerNames.get(Variables.turnNumber);
            Variables.currentPlayer = "Its "+Pname + "'s Turn"+" on round: " + Variables.roundNumber;
            System.out.println(Variables.currentPlayer); 
        
        }
        else
        {
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
    
    public static int NextTurn() throws InterruptedException
    {
        Variables.turnNumber++; //Adds 1 to Current Turn 
        boolean reArm = CheckForRoundEnd();
        PrintPlayerTurn();
        if(reArm)
        	return Variables.turnNumber;
        else return -1;
        //TimerHandler.TurnTime90();
        
        
    }

}