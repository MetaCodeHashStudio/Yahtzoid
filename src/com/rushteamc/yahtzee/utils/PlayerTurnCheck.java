package com.rushteamc.yahtzee.utils;
/**
 * @author Runnetty
 */
public class PlayerTurnCheck {
    
    public static int NrPlyrs = 4; //Set how many Players thats will play.
    public static String[] Players = new String[NrPlyrs];
    
    public static String Curplayer = ""; //Will Display
    public static int Turn = 1;
    public static int Round = 1;
    
    public static void CheckForPlayerTurn()
    {   
        
        /*Checks Curent Turn is greater than the number of players*/
        /////////////////////////////////////////////////////////////
            for(int MaxTurns = NrPlyrs; Turn > MaxTurns;)
        {
            System.out.println("The current round is finished");
            Round++;
            Turn=1;
        }
        /////////////////////////////////////////////////////////////
    }
    
    public static void PrintPlayerTurn()
    {
        Curplayer = "Its Player " + Turn + "'s Turn"+" on round: " + Round;
        System.out.println(Curplayer); 
    }
    
     public static void TotalPlayingPlayers()
             
    {
        System.out.println("There are: "+Players.length+ " players");   
    }
    
     public static void NextTurn()
    {
        Turn++; //Adds 1 to Current Turn 
        CheckForPlayerTurn();
        PrintPlayerTurn();
    }

}