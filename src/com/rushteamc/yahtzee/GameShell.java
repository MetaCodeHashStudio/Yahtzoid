package com.rushteamc.yahtzee;

import java.awt.EventQueue;

import com.rushteamc.yahtzee.gui.PlayerNames;
import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.gui.SplashGUI;

public class GameShell implements IGameShell {

	private String gameVersion = "0.0.1";
	private int numPlayers;
	public Game yahtzoidGame;
	
	
	public GameShell() {
		
		EventQueue.invokeLater(
				new Runnable() {

					@Override
					public void run() {
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
	
	public void newGame(int Stage) {
		if (Stage == 1) {
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					try {
						PlayerNumbers playerNumbersFrame = new PlayerNumbers(
								gameVersion);
						playerNumbersFrame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});
		}
		if (Stage == 2) {
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					try {
						PlayerNames playerNamesFrame = new PlayerNames(
								gameVersion, numPlayers);
						playerNamesFrame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});
		}
	}
	
	public void saveGame() {
		
	}
	
	public void loadGame() {
		
	}
	
	public void quitGame() {
		
	}
	
	public void setPlayerNumbers(int players)
	{
		this.numPlayers = players;
	}
}
