package com.rushteamc.yahtzee;
import java.awt.EventQueue;
import java.net.URISyntaxException;

import com.rushteamc.yahtzee.utils.Variables;

public class Start
{
	public static com.rushteamc.yahtzee.gui.PlayerNumbers PlayerNumberFrame;
	public static com.rushteamc.yahtzee.gui.PlayerNames PlayerNamesFrame;

	public static void main(String[] args) throws URISyntaxException // Start script begins with launching PlayerNumbers check.
	{         
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
	public static void debugDie(int[] Die, int[] Values)
	{
		System.out.println("Die array looks like: ");
		for
		(
			int i = 0;
				i < Die.length;
				i++
		)
		{
			System.out.print(Die[i] + " ");
		}
		System.out.println();
		System.out.println("The values array now looks like: ");
		for (int i = 1; i <= com.rushteamc.yahtzee.utils.Configurables.getDieSize(); i++)
		{
			System.out.print(i+"\t");
		}
		System.out.println();
		for (int k = 0; k < com.rushteamc.yahtzee.utils.Configurables.getDieSize(); k++)
		{
			System.out.print(Values[k] + "\t");
		}
		System.out.println();
	}

}
