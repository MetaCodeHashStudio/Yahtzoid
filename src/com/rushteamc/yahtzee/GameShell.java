package com.rushteamc.yahtzee;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.gui.SplashGUI;

public class GameShell implements IGameShell {

	private String gameVersion = "0.0.1";
	private int numPlayers;
	
	public GameShell() {
		
		EventQueue.invokeLater(
				new Runnable() {
					
					@Override
					public void run(){
						try {
							
							SplashGUI splashGUI = new SplashGUI();
							splashGUI.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			);
		
		
	}
	
	public void newGame() {
		
		
		try {
		EventQueue.invokeAndWait(
				new Runnable() {
		
					@Override
					public void run() {
						try {
							System.out.println("HEI IGJEN!");
							PlayerNumbers playerNumbersFrame = new PlayerNumbers(gameVersion);
							playerNumbersFrame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void saveGame() {
		
	}
	
	public void loadGame() {
		
	}
	
	public void quitGame() {
		
	}
}
