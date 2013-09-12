package com.rushteamc.yahtzee.utils;
/**
 * @author Runnetty
 */
public class PlayerTurnCheck {
    
    public static int NrPlyrs = 4; //Set how many Players thats will play.
    public static String[] Players = new String[NrPlyrs];
    
    public static String Curplayer = ""; //Will Display
    public static int Turn = 0;
    public static int Round = 1;
    
    public static void CheckForPlayerTurn()
    {   
        
        for(int MaxTurns = NrPlyrs; Turn < MaxTurns;)
        {
            PrintPlayerTurn();
        }
        
        
        
        
        /*Checks Curent Turn*/
        /* - Trying to Easyfy this
        ////////////////////////////////
        if(Turn == 1)
        {
             PrintPlayerTurn();
        }
        if(Turn == 2)
        {
            PrintPlayerTurn(); 
        }
        if(Turn == 3)
        {
           PrintPlayerTurn();
        }      
        if(Turn == 4)
        {
           PrintPlayerTurn();
          Round++;
          Turn = 0;
        }
        //////////////////////////////////
        */
    }
    
    public static void PrintPlayerTurn()
    {
        Curplayer = "Its Player " + Turn + "'s Turn"+" on round: " + Round;
        System.out.println(Curplayer);   
        
    }
    
     public static void NextTurn()
    {
        Turn++; //Adds 1 to Current Turn
        
    }

}