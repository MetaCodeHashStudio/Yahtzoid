package com.rushteamc.yahtzee;
import java.awt.EventQueue;
import java.net.URISyntaxException;

import com.rushteamc.yahtzee.dice.Dice;
import com.rushteamc.yahtzee.utils.Variables;

public class Start
{
	
	public static com.rushteamc.yahtzee.gui.PlayerNumbers PlayerNumberFrame;
	public static com.rushteamc.yahtzee.gui.PlayerNames PlayerNamesFrame;

	public static void main(String[] args) throws URISyntaxException // Start script begins with launching PlayerNumbers check.
	{
		Dice[] dice = new Dice[7];
		
		for(int i = 0 ; i < 4 ; i++)
		{
			dice[i] = new Dice(6);
		}
		dice[5] = new Dice(6);
		dice[5].setActive(false);
		dice[6] = new Dice(8);
		dice[6].setActive(false);
		
		System.out.println(dice[0].getValue());
		System.out.println(dice[0].getSize());
		
		System.out.println(com.rushteamc.yahtzee.utils.FileHandling.getWorkingPaths());
		EventQueue.invokeLater
		(
			new Runnable() 
			{
				public void run()
				{
					try
					{
						PlayerNumberFrame = new com.rushteamc.yahtzee.gui.PlayerNumbers();
						PlayerNumberFrame.setVisible(true);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	public static void continueToNames() // Called by the event handler of PlayerNumbers. Starts PlayerNames check.
	{
		EventQueue.invokeLater
		(
			new Runnable() 
			{
				public void run()
				{
					try
					{
						PlayerNamesFrame = new com.rushteamc.yahtzee.gui.PlayerNames();
						PlayerNamesFrame.setVisible(true);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		);
		
	}
	public static void startGame() // Actual GUI starter.
	{
		EventQueue.invokeLater
		(
			new Runnable()
			{
				public void run()
				{
					try 
					{
						com.rushteamc.yahtzee.gui.GUI GUI = new com.rushteamc.yahtzee.gui.GUI();
						GUI.setVisible(true);	
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	/*
	 * Begin event handlers.
	 */
	public static void setPlayerNumHandler()
	{
		com.rushteamc.yahtzee.gui.handlers.PlayerNumbersHandlers.generateNumbers();
	}
	public static void setPlayerNameHandler()
	{
		com.rushteamc.yahtzee.gui.handlers.PlayerNamesHandlers.generateNames();
	}
	/*
	 * End begin event handlers.
	 * Begin debug methods.
	 */


}
