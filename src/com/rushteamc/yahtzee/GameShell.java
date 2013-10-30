package com.rushteamc.yahtzee;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.gui.SplashGUI;

public class GameShell implements IGameShell {

	private String gameVersion = "0.0.1";
	private String commandToRun = "";
	
	
	public GameShell() {
		
		EventQueue.invokeLater(
				new Runnable() {

					@Override
					public void run() {
					try {
	
						SplashGUI splashGUI = new SplashGUI(GameShell.this);
						splashGUI.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		);

	}
	
	public void newGame() {
		EventQueue.invokeLater(
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
	}
	
	public void saveGame() {
		
	}
	
	public void loadGame() {
		
	}
	
	public void quitGame() {
		
	}
}
