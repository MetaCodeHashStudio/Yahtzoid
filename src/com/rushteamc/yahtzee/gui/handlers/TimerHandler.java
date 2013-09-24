package com.rushteamc.yahtzee.gui.handlers;
/*
 * @author Runnetty
 */

import com.rushteamc.yahtzee.utils.PlayerTurnCheck;

public class TimerHandler {
    
    public static int threadSecond = 1000;
    public static int second = 1;
    public static int minute = second*60;
    public static int TurnTime = 3;
    public static boolean f = false;
    
    public static void TurnTime90() throws InterruptedException{
        
            for(int i = TurnTime; i >=0; i--){
                
                Thread.sleep(threadSecond);
                System.out.println(i);
            }
                 PlayerTurnCheck.NextTurn();

    }
}
