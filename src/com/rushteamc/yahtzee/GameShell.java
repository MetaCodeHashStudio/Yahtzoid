package com.rushteamc.yahtzee;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.rushteamc.yahtzee.gui.PlayerNames;
import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.gui.SplashGUI;

public class GameShell implements IGameShell {

	private String gameVersion = "0.0.1";
	public Game game;
	
	
	// TODO Merge GUIs
	private SplashGUI splashGUI;
	private PlayerNumbers playerNumbers;
	private PlayerNames playerNames;
	private static final String SAVE_FILE_NAME = "save.dat";
	
	private int numberOfPlayers;

	public GameShell() {
		mainMenu();
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
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(SAVE_FILE_NAME))))
        {
            out.writeObject(this.game);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}

	public void loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(SAVE_FILE_NAME))))
        {
            this.game = (Game) in.readObject();

//            System.out.println(this.game.getPlayers());
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
	}

	public void quitGame() {

	}
	/*
	 * 
	 * Methods not part of interface:
	 * 
	 */
	public void mainMenu() {
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
}
