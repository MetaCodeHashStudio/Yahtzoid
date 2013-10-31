package com.rushteamc.yahtzee;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.rushteamc.yahtzee.gui.PlayerNames;
import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.gui.SplashGUI;

public class GameShell implements IGameShell {

	private String gameVersion = "0.0.1";
	public Game yahtzoidGame;
	private SplashGUI splashGUI;
	private PlayerNumbers playerNumbers;
	private PlayerNames playerNames;
	
	private int numberOfPlayers;

	public GameShell() {

		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					
					try {
						splashGUI = new SplashGUI();
						splashGUI.setVisible(true);
					} catch (IllegalMonitorStateException e) {
						e.printStackTrace();
					}
				}
			});
			
			synchronized (splashGUI) {
				try {
					while (splashGUI.getWaitState()) {
						splashGUI.wait(50);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String command = splashGUI.getCommand();
		System.out.println(command);
		splashGUI.dispose();
		
		switch (command) {
		case "newGame":
			this.newGame();
			break;
		case "saveGame":
			this.saveGame();
			break;
		case "loadGame":
			this.loadGame();
			break;
		case "quitGame":
			this.quitGame();
			break;
		}
		
	}

	public void newGame() {
		String[] players;
		
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					try {
						playerNumbers = new PlayerNumbers(gameVersion);
						playerNumbers.setVisible(true);
					} catch (IllegalMonitorStateException e) {
						e.printStackTrace();
					}
				}
			});
			synchronized (playerNumbers) {
				try {
					while (playerNumbers.getWaitState()) {
						playerNumbers.wait(50);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		numberOfPlayers = playerNumbers.getSelection();
		playerNumbers.dispose();
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					try {
						playerNames = new PlayerNames(gameVersion, numberOfPlayers);
						playerNames.setVisible(true);
					} catch (IllegalMonitorStateException e) {
						e.printStackTrace();
					}
				}
			});
			synchronized (playerNames) {
				try {
					while (playerNames.getWaitState()) {
						playerNames.wait(50);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		players = playerNames.getPlayerNames();
		playerNames.dispose();
		
		
		
	}

	public void saveGame() {

	}

	public void loadGame() {

	}

	public void quitGame() {

	}
}
