package com.rushteamc.yahtzee.utils;
/**
 * @author Runnetty
 */
public class PlayerTurnCheck {
    
    public static int NrPlyrs = 4; //Set how many Players thats will play.
    public static String[] Playersstring = new String[NrPlyrs];
    
    public static String Curplayer; // Will Output Current Player on round
    public static String TotalPlayers; // Will Output Total Players 
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
        String Pname = (String) Players.PlayerNames.get(Turn-1);
        Curplayer = "Its "+Pname + "'s Turn"+" on round: " + Round;
        System.out.println(Curplayer); 
    }
    
     public static void TotalPlayingPlayers()
             
    {
        TotalPlayers = "There are: "+Playersstring.length+ " players";
        System.out.println(TotalPlayers);   
    }
    
     public static void NextTurn()
    {
        Turn++; //Adds 1 to Current Turn 
        CheckForPlayerTurn();
        PrintPlayerTurn();
    }

}