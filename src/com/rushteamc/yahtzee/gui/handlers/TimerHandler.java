package com.rushteamc.yahtzee.gui.handlers;
/*
 * @author Runnetty
 */
/*
import com.rushteamc.yahtzee.utils.PlayerTurnCheck;

public class TimerHandler {
    
    public static int threadSecond = 1000;
    
    public static int second = 1;
    public static int minute = second*60;
    
    public static int TurnTime = 3;
    public static boolean PTurnTime = false;
    
    public static void TurnTime90() throws InterruptedException{
        if(PTurnTime==false){
            for(int i = TurnTime; i >=0; i--){
                
                Thread.sleep(threadSecond);
                System.out.println(i+ " seconds left.");
            }
                 PlayerTurnCheck.NextTurn();
        }else{
            System.out.println("Paused the Timer");
        }
    }
    
    public static void PauseTurnTime(){
        PTurnTime = true;
    }
    
        public static void unPauseTurnTime(){
        PTurnTime = false;
    }
    
}
*/